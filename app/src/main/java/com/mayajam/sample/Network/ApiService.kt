package com.mayajam.sample.Network

import com.mayajam.sample.Mission.Mission
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ApiService {
    @Inject
    lateinit var api:ApiInterface

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getMissions(): Single<Array<Mission>> {
       return api.getMissions()
    }
}