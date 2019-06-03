package com.example.training_4_29.movieDb.model.data.remote

import android.annotation.SuppressLint
import android.util.Log
import com.example.training_4_29.movieDb.model.data.DataSource
import com.example.training_4_29.movieDb.model.entities.Result
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val service: RemoteService) : DataSource {

    @SuppressLint("CheckResult")
    override fun getMovieList(callback: (List<Result>) -> Unit) {
        service.movieListStream("godfather", 1, "en_US")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { movieSearchResult ->
                movieSearchResult.results
            }
            .subscribe (object: Observer<List<Result>>{
                override fun onComplete() {
                    Log.d(RemoteDataSource::class.java.simpleName, "onComplete: ")
                }
                override fun onSubscribe(d: Disposable) {
                    Log.d(RemoteDataSource::class.java.simpleName, "onSubscribe: ")
                }

                override fun onNext(t: List<Result>) {
                    Log.d(RemoteDataSource::class.java.simpleName, "onNext: ${t.size}")
                    callback.invoke(t)
                }

                override fun onError(e: Throwable) {
                    Log.d(RemoteDataSource::class.java.simpleName, "onError: ${e.printStackTrace()}")
                }
            } )
    }


    override fun saveMovieList(movieList: List<Result>, callback: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}