package com.example.training_4_29.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.manager.NetworkManager
import com.example.training_4_29.network.OkHttpHelper
import com.example.training_4_29.network.RetrofitHelper
import com.example.training_4_29.rxjava.RxJavaHelper
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

        val retrofitHelper = RetrofitHelper(applicationContext)
        btnRetrofitAsync.setOnClickListener {
            //using retrofit enqueue method
            retrofitHelper.getUserList("10") {
                it.results?.forEach { user -> toast(user.name?.first) }
            }

            //using rxjava retrofit call adapter
            retrofitHelper.getUserListObs("10") {
                it.results?.forEach {
                    Log.d(NetworkActivity::class.java.simpleName, "onCreate: ${it.name?.first}") }
            }


        }


        val rxJavaHelper = RxJavaHelper(1)
        btnStartListening.setOnClickListener {
            rxJavaHelper
                .listenToObservable { Log.d(NetworkActivity::class.java.simpleName, "onCreate: $it") }

        }

        btnStopListening.setOnClickListener { rxJavaHelper.stopListening() }


    }
}
