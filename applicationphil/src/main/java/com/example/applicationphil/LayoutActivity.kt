package com.example.applicationphil

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.applicationphil.KotlinReview.Animal
import com.example.applicationphil.KotlinReview.Person

class MainActivity : AppCompatActivity() {
    lateinit var etMain: EditText
    var updatedString: String = ""

    lateinit var etPersonName: EditText
    lateinit var etPersonAge: EditText
    lateinit var etPersonGender: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("${MainActivity::javaClass.name}_TAG", "onCreate")

        val textView = findViewById<TextView>(R.id.tvWorld)
        textView.text = "Some other world"

        val buttonchangeText = findViewById<Button>(R.id.btnChangeText)
        setChangeTextListener(buttonchangeText, textView)

        val newTextView = TextView(this).apply { text = "New TextView" }
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        linearLayout.addView(newTextView)

        etMain = findViewById<EditText>(R.id.etMain)
        etPersonName = findViewById(R.id.etPersonName)
        etPersonAge = findViewById(R.id.etPersonAge)
        etPersonGender = findViewById(R.id.etPersonGender)
    }

    fun startSecondActivity(view: View) {
        // create person object
        val person = Person(
            etPersonName.text.toString(),
            etPersonAge.text.toString().toInt(),
            etPersonGender.text.toString())

        val intent = Intent(applicationContext, SecondActivity::class.java)
        intent.putExtra("someKey", "someValue")
        intent.putExtra("person", person)
        intent.putExtra("animal", Animal("Cat", 37, "Female"))
        startActivity(intent)
    }

    private fun setChangeTextListener(buttonchangeText: Button, textView: TextView) {
        buttonchangeText.setOnClickListener {
            textView.text = "New World"
            updatedString = "New Updated String"
        }

    }

    fun onSecondClicked(view: View) {
        Toast.makeText(this, "Something", Toast.LENGTH_SHORT).show()
        etMain.setText("${updatedString}:${etMain.text}")
    }


    override fun onStart() {
        super.onStart()
        Log.d("${MainActivity::javaClass.name}_TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("${MainActivity::javaClass.name}_TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("${MainActivity::javaClass.name}_TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("${MainActivity::javaClass.name}_TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("${MainActivity::javaClass.name}_TAG", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("${MainActivity::javaClass.name}_TAG", "onRestart")
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d("${MainActivity::javaClass.name}_TAG", "onSaveInstanceState")
        outState?.putString("updatedString", updatedString)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("${MainActivity::javaClass.name}_TAG", "onRestoreInstanceState")
        updatedString = savedInstanceState?.getString("updatedString") ?: ""
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        val result: String = when (newConfig?.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "Portrait"
            Configuration.ORIENTATION_LANDSCAPE -> "Landscape"
            else -> "Unknown Configuration"
        }

        Log.d("${MainActivity::javaClass.name}_TAG", "onConfigurationChanged:$result")
    }
}
