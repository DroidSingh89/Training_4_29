package com.example.applicationphil.thread

import com.example.applicationphil.manager.TaskManager

class MyThread(val sequence: Int): Thread() {

    override fun run() {
        TaskManager.startTask(sequence)
        super.run()
    }

}