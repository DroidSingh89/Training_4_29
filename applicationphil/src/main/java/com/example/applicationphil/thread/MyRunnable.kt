package com.example.applicationphil.thread

import com.example.applicationphil.manager.TaskManager

class MyRunnable(val sequence: Int) : Runnable {

    override fun run() {
        TaskManager.startTask(sequence)
    }
}