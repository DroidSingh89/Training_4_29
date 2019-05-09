package com.example.training_4_29.threads

import com.example.training_4_29.manager.TaskManager

class MyRunnable(val sequence: Int) : Runnable{

    override fun run() {
        TaskManager.startTask(this, sequence)
    }
}