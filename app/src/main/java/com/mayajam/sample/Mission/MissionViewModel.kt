package com.mayajam.sample.Mission

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayajam.sample.Network.ApiInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MissionViewModel: ViewModel() {
    private val disposable = CompositeDisposable()

    val missions: MutableLiveData<Array<Mission>> = MutableLiveData()

    fun getMissions(){
        ApiInterface.getInstance().getMissions()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<Array<Mission>>(){
                override fun onSuccess(t: Array<Mission>) {
                    missions.value =t
                }

                override fun onError(e: Throwable) {
                    println(e.message)
                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}