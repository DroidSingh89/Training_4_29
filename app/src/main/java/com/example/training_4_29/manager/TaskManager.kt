package com.example.training_4_29.manager

import android.util.Log

object TaskManager {

    fun startTask(any: Any, sequence: Int) {
        (1..sequence).forEach {
            Thread.sleep(500)
            Log.d(
                "ThreadingActivity", "$any task $it running " +
                        "on ${Thread.currentThread().name}"
            )
        }
    }
}