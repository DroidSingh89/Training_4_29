package com.example.training_4_29.activity

import android.os.Bundle
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.manager.NetworkManager
import com.example.training_4_29.network.OkHttpHelper
import com.example.training_4_29.network.RetrofitHelper
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        btnHttpUrlConnection.setOnClickListener { NetworkManager.makeRequest(NetworkManager.PROVIDER.NATIVE) }

        btnOkhttpAsync.setOnClickListener {
            OkHttpHelper().makeAsyncRequest { response ->
                runOnUiThread {
                    val user = response.results?.get(0)?.let {
                        "Name : ${it.name?.first} + ${it.name?.last}, Gender: ${it.gender}"
                    }
                    toast(user)
                }
            }
        }

        btnRetrofitAsync.setOnClickListener {
            RetrofitHelper().getUserList("10") {
                it.results?.forEach { user -> toast(user.name?.first) }
            }
        }

    }
}
