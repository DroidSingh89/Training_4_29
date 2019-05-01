package com.example.applicationphil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tvWorld)
        setText(textView)

    }

    private fun setText(textView: TextView) {
        textView.setText("Some other world")
    }
}
