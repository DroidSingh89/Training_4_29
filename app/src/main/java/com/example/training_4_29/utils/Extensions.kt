package com.example.training_4_29.utils

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

class Test{

    inline fun <reified T> Context.startActivityWithNoExtras(cls: Class<out T>){
        this.startActivity(Intent(this.applicationContext, cls))
    }
}
