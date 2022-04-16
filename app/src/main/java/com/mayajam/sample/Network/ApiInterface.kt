package com.mayajam.sample.Network

import com.mayajam.sample.Mission.Mission
import io.reactivex.rxjava3.core.Single
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @GET("missions")
    fun getMissions() : Single<Array<Mission>>

    companion object {
        val BASE_URL = "https://api.spacexdata.com/v3/"
        private const val TIMEOUT: Long = 50000

        fun getInstance()  : ApiInterface {
            val retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getClientBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }

        private fun getClientBuilder(): OkHttpClient.Builder {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .connectionPool(ConnectionPool(0, 5, TimeUnit.MINUTES))
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .addInterceptor(loggingInterceptor)
            return client
        }
    }

}