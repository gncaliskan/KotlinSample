package com.mayajam.sample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mayajam.sample.Mission.Mission
import com.mayajam.sample.Mission.MissionViewModel
import com.mayajam.sample.Network.ApiService
import io.reactivex.rxjava3.core.Single
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MissionViewModelTest {
    lateinit var closeable: AutoCloseable


    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    @InjectMocks
    var missionViewModel = MissionViewModel()

    private var testSingle : Single<Array<Mission>>? =null

    @Before
    fun setUp(){
        closeable = MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getMissionsSuccess(){
        val mission = Mission("mission_name", "mission_id")
        val missionList: Array<Mission> = arrayOf(mission)

        testSingle = Single.just(missionList)

    }


    @After
    fun closeService(){
        closeable.close()
    }
}