package com.example.training_4_29.threads

import android.util.Log
import com.example.training_4_29.manager.TaskManager

class MyThread(val sequence: Int) : Thread() {

    override fun run() {
        Log.d("MyThread", "onRun: $sequence")
        TaskManager.startTask(this, sequence)
        super.run()
    }
}