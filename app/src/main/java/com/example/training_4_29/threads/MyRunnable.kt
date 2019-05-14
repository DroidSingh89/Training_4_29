package com.example.training_4_29.threads

import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.training_4_29.manager.TaskManager
import com.example.training_4_29.model.entities.MessageEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MyRunnable(val handler: Handler, val sequence: Int) : Runnable {

    override fun run() {

        EventBus.getDefault().register(this)

        TaskManager.startTask(this::class.java.simpleName, sequence) { sendMessage(it) }

        EventBus.getDefault().unregister(this)
    }

    private fun sendMessage(int: Int) {
        val message = Message()
        message.data.putInt("value", int)
        handler.sendMessage(message)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageReceived(message: MessageEvent){
        Log.d(MyRunnable::class.java.simpleName, "onMessageReceived: ${message.data} " +
                "on ${Thread.currentThread().name}")
    }

}