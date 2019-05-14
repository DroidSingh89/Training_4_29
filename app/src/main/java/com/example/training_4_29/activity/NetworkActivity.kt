package com.example.training_4_29.activity

import android.os.Bundle
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.manager.NetworkManager
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        btnHttpUrlConnection.setOnClickListener { NetworkManager.makeRequest(NetworkManager.PROVIDER.NATIVE) }

        btnOkhttpSync.setOnClickListener {  }
    }
}
