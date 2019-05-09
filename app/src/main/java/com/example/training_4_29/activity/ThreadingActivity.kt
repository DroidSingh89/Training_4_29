package com.example.training_4_29.activity

import android.os.Bundle
import android.view.View
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.threads.MyRunnable
import com.example.training_4_29.threads.MyThread
import kotlinx.android.synthetic.main.activity_threading.*

class ThreadingActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threading)

        btnThread.setOnClickListener(this)

        btnRunnable.setOnClickListener { MyRunnable(10).run() }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnThread -> MyThread(10).start()
        }
    }
}
