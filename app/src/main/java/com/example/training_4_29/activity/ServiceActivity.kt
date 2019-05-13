package com.example.training_4_29.activity

import android.content.Intent
import android.os.Bundle
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.service.MyNormalService
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val normalIntent  = Intent(applicationContext, MyNormalService::class.java).putExtra("key", "some data")
        btnStartNormal.setOnClickListener { startService(normalIntent) }
        btnStopNormal.setOnClickListener { stopService(normalIntent) }
    }
}
