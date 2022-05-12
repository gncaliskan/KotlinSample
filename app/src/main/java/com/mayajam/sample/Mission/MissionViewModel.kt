package com.mayajam.sample.Mission

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayajam.sample.Network.ApiService
import com.mayajam.sample.Network.DaggerApiComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MissionViewModel : ViewModel() {
    @Inject
    lateinit var apiService:ApiService
    private val disposable = CompositeDisposable()
    val missions: MutableLiveData<Array<Mission>> = MutableLiveData()

    init {
        DaggerApiComponent.create().inject(this)
    }
    fun getMissions() {
        disposable.add(
            apiService.getMissions()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Array<Mission>>() {
                    override fun onSuccess(t: Array<Mission>) {
                        missions.value = t
                    }

                    override fun onError(e: Throwable) {
                        println(e.message)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}