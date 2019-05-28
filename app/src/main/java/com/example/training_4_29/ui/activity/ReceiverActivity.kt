package com.example.training_4_29.ui.activity

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.example.training_4_29.ui.base.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.receiver.MyDynamicReceiver
import com.example.training_4_29.utils.ACTION_CUSTOM
import com.example.training_4_29.utils.ACTION_CUSTOM_OUTSIDE
import com.example.training_4_29.utils.KEY_CUSTOM
import com.example.training_4_29.utils.KEY_CUSTOM_OUTSIDE
import kotlinx.android.synthetic.main.activity_receiver.*


class ReceiverActivity : BaseActivity() {

    lateinit var myDynamicReceiver: MyDynamicReceiver
    lateinit var myIntentFilter: IntentFilter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        myDynamicReceiver = MyDynamicReceiver(tvReceiverContent)
        myIntentFilter = IntentFilter()


        btnSendBroadcast.setOnClickListener {
            sendBroadcast(Intent(ACTION_CUSTOM)
                .putExtra(KEY_CUSTOM, etReceiverContent.text.toString())) }

        btnSendBroadcastOutside.setOnClickListener {
            sendBroadcast(
                Intent(ACTION_CUSTOM_OUTSIDE)
                    .putExtra(KEY_CUSTOM_OUTSIDE, etReceiverContent.text.toString())
                , Manifest.permission.READ_SMS) }
    }


    override fun onStart() {
        super.onStart()
        myIntentFilter.addAction(ACTION_CUSTOM)
        registerReceiver(myDynamicReceiver, myIntentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(myDynamicReceiver)
    }

}
