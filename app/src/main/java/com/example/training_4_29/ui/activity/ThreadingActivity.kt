package com.example.training_4_29.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import com.example.training_4_29.ui.base.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.model.entities.MessageEvent
import com.example.training_4_29.threads.MyAsyncTask
import com.example.training_4_29.threads.MyRunnable
import com.example.training_4_29.threads.MyThread
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_threading.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ThreadingActivity : BaseActivity(), View.OnClickListener, Handler.Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threading)

        btnThread.setOnClickListener(this)

        btnRunnable.setOnClickListener {
            //MyRunnable(10).run() //run on current main thread
            Thread(MyRunnable(Handler(this), 10)).start()
        } //start a new thread

        btnAsyncTask.setOnClickListener {
            MyAsyncTask { tvResult.text = it.toString() }
                .execute(10)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnThread -> MyThread(10).start()
        }
    }

    override fun handleMessage(msg: Message?): Boolean {
        toast(msg?.data?.getInt("value").toString())
        return false
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(message: MessageEvent){
        Log.d(ThreadingActivity::class.java.simpleName, "onMessageEvent: ${message.data} " +
                "on ${Thread.currentThread().name}")

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEventAgain(message: MessageEvent){

        Log.d(ThreadingActivity::class.java.simpleName, "onMessageEventAgain: ${message.data}" +
                "on ${Thread.currentThread().name}")
    }


}
