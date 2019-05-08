package com.example.training_4_29

import android.content.ContentValues.TAG
import android.util.Log

class Test(internal var repository: Repository) {

    internal fun getResultsAsync(callback: Callback) {

        repository.getResults(object : Callback {
            override fun onResult(value: String) {
                Log.d(TAG, "onResult: $value")
            }
        })
    }

    inner class Repository {

        internal fun getResults(callback: Callback) {

            //do async
            callback.onResult("some value")
        }
    }
}


internal interface Callback {
    fun onResult(value: String)
}
