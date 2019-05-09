package com.example.training_4_29.threads

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.training_4_29.manager.TaskManager


class MyThread(val sequence: Int) : Thread() {


    val handler: Handler = Handler(Looper.getMainLooper())

    override fun run() {
        Log.d("MyThread", "onRun: $sequence")
        TaskManager.startTask(this::class.java.simpleName, sequence){sendMessage(it)}

        super.run()
    }


    fun sendMessage(int: Int){

        handler.post { Log.d(MyThread::class.java.simpleName,
            "sendMessage: ${currentThread().name} task running: $int") }
    }
}