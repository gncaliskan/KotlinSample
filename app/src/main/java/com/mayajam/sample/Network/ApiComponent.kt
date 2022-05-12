package com.mayajam.sample.Network

import com.mayajam.sample.Mission.MissionViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service:ApiService)
    fun inject(viewModel:MissionViewModel)
}