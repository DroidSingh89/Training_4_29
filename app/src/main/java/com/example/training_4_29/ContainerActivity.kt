package com.example.training_4_29

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onCreate")

        val textView = findViewById<TextView>(R.id.tvWorld)
        textView.text = "Some other world"

        val buttonchangeText = findViewById<Button>(R.id.btnChangeText)
        setChangeTextListener(buttonchangeText, textView)

        val newTextView = TextView(this).apply { text = "New TextView" }
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        linearLayout.addView(newTextView)
    }

    private fun setChangeTextListener(buttonchangeText: Button, textView: TextView) {
        buttonchangeText.setOnClickListener { textView.text = "New World" }
    }

    fun onSecondClicked(view: View) {
        Toast.makeText(this, "Something", Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        super.onStart()
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("${ContainerActivity::javaClass.name}_TAG", "onRestart")
    }
}
