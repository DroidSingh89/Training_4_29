package com.example.training_4_29.utils

import android.content.Context
import android.content.Intent
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


fun Context.toast(message: String?){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View{
    return LayoutInflater.from(this.context).inflate(layoutRes,this, attachToRoot)
}

class Test{

    inline fun <reified T> Context.startActivityWithNoExtras(cls: Class<out T>){
        this.startActivity(Intent(this.applicationContext, cls))
    }
}
