package com.example.training_4_29.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_storage.*

class StorageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        val sharedPref : SharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPref.edit()

        btnSaveData.setOnClickListener {
            editor.putString("value", etSharedPref.text.toString())
//            editor.commit() //commit() return boolean and would write the data
//            synchronously, apply() would do async
            editor.apply()
            toast("Saved")
        }
        btnGetData.setOnClickListener { toast(sharedPref.getString("value", "default value")) }
        btnClearData.setOnClickListener {
            editor.clear()
            editor.apply()
            toast("Cleared")
        }

    }
}
