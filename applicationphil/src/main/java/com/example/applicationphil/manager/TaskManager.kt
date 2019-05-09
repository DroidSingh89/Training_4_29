package com.example.applicationphil.manager

import android.util.Log

object TaskManager {

    fun startTask(sequence: Int){
        (1..sequence).forEach{
            Thread.sleep(500)
            Log.d("OnUpdate", "ThreadingActivity: tick $it")
        }
    }

}