package com.mayajam.sample.Network

import com.mayajam.sample.Mission.Mission
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface ApiInterface {

    @GET("missions")
    fun getMissions() : Single<Array<Mission>>


}