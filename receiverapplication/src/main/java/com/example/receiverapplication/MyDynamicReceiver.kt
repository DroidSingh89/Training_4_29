package com.example.receiverapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.TextView

const val KEY_CUSTOM_OUTSIDE = "key_outside"
const val ACTION_CUSTOM_OUTSIDE = "receiverapplication.ACTION_OUTSIDE"
class MyDynamicReceiver(val tvReceiverContent: TextView) : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
      Log.d(MyDynamicReceiver::class.java.simpleName, "onReceive: ")

        tvReceiverContent.text = intent.getStringExtra(KEY_CUSTOM_OUTSIDE)
    }
}
