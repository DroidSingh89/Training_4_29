package com.example.training_4_29.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.training_4_29.ui.base.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.ui.customviews.ToastedButton
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        btnToastedButton.setOnToastClickListener(object: ToastedButton.OnToastClickListener{
            override fun onClick() {
                Log.d(CustomViewActivity::class.java.simpleName, "onClick: From Activity")
            }
        })
    }
}
