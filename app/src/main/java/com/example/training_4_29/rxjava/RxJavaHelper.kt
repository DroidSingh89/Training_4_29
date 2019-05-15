package com.example.training_4_29.rxjava

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RxJavaHelper(val period: Long) {

    lateinit var intervalObservable: Observable<Long>
    lateinit var disposable: Disposable

    private fun createIntervalObservable(period: Long): Observable<Long>{
        intervalObservable = Observable.interval(period, TimeUnit.SECONDS)
        return intervalObservable
    }

    @SuppressLint("CheckResult")
    fun listenToObservable(callback: (Long)-> Unit){
        disposable = createIntervalObservable(period)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it*it }
            .filter { it%3==0L }
            .subscribe { callback.invoke(it) }
    }

    fun stopListening(){
        disposable.dispose()
    }
}