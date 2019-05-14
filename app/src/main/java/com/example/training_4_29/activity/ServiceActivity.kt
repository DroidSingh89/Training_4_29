package com.example.training_4_29.activity

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.support.annotation.RequiresApi
import android.util.Log
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.service.MyBoundService
import com.example.training_4_29.service.MyIntentService
import com.example.training_4_29.service.MyJobService
import com.example.training_4_29.service.MyNormalService
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : BaseActivity(), ServiceConnection {

    lateinit var myBoundService: MyBoundService
    var isBound = false

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val normalIntent = Intent(applicationContext, MyNormalService::class.java).putExtra("key", "some data")
        btnStartNormal.setOnClickListener { startService(normalIntent) }
        btnStopNormal.setOnClickListener { stopService(normalIntent) }

        btnStartFoo.setOnClickListener {
            MyIntentService.startActionFoo(applicationContext, "foo1", "foo2")
        }

        btnStartBaz.setOnClickListener {
            MyIntentService.startActionBaz(applicationContext, "baz1", "baz2")
        }


        //bind service
        val bindIntent = Intent(applicationContext, MyBoundService::class.java)
        btnBindService.setOnClickListener { bindService(bindIntent, this, Context.BIND_AUTO_CREATE) }

        btnAddToList.setOnClickListener { if (isBound) myBoundService.addToList(etAddToList.text.toString()) }
        btnClearList.setOnClickListener { if (isBound) myBoundService.clearList() }
        btnPrintList.setOnClickListener {
            if (isBound) myBoundService.dataList.forEach {
                Log.d(ServiceActivity::class.java.simpleName, "onCreate: $it")
                toast(it)
            }
        }

        btnUnBindService.setOnClickListener {
            if (isBound) {
                unbindService(this)
                isBound = false
            }
        }


//        scheduling a job
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val componentName = ComponentName(applicationContext, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(0, componentName)
            .setMinimumLatency(1000)
            .setRequiresCharging(true)
            .build()

        btnScheduleService.setOnClickListener {
            jobScheduler.schedule(jobInfo)
        }

    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

        val binder = service as MyBoundService.MyBinder
        myBoundService = binder.getService()
        isBound = true
        toast("Bounded")

    }

    override fun onServiceDisconnected(name: ComponentName?) {
        isBound = false
        toast("Unbounded")
    }
}
