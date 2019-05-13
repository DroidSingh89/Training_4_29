package com.example.receiverapplication

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myDynamicReceiver: MyDynamicReceiver
    lateinit var myIntentFilter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myDynamicReceiver = MyDynamicReceiver(tvReceiverContent)
        myIntentFilter = IntentFilter()
    }



    override fun onStart() {
        super.onStart()
        myIntentFilter.addAction(ACTION_CUSTOM_OUTSIDE)
        registerReceiver(myDynamicReceiver, myIntentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myDynamicReceiver)
    }
}
