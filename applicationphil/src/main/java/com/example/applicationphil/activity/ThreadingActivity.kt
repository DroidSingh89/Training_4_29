package com.example.applicationphil.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.applicationphil.BaseActivity
import com.example.applicationphil.R
import com.example.applicationphil.thread.MyRunnable
import com.example.applicationphil.thread.MyThread
import kotlinx.android.synthetic.main.activity_threading.*

class ThreadingActivity : BaseActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threading)

        Log.d(ThreadingActivity::class.java.simpleName, "onCreate")

        tvResult.text = "It works!"
        btnThread.setOnClickListener(this)
        btnRunnable.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        tvResult.text = "Button clicked"
    }

}