package com.example.training_4_29.threads

import android.os.Handler
import android.os.Message
import com.example.training_4_29.manager.TaskManager

class MyRunnable(val handler: Handler, val sequence: Int) : Runnable{

    override fun run() {

        TaskManager.startTask(this::class.java.simpleName, sequence){sendMessage(it)}
    }

    private fun sendMessage(int : Int){
        val message = Message()
        message.data.putInt("value", int)
        handler.sendMessage(message)
    }
}