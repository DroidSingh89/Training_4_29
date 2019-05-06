package com.example.applicationphil

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.applicationphil.KotlinReview.Animal
import com.example.applicationphil.KotlinReview.Person

class SecondActivity : AppCompatActivity() {

    lateinit var etShareContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val valueFromIntent: String? = intent.getStringExtra("someKey") ?: "Default Value"
        val person = intent.getSerializableExtra("person") as Person
        val animal = intent.getParcelableExtra<Animal>("animal")
        Log.d("${SecondActivity::class.java.simpleName}_TAG", person.name)
        Log.d("${SecondActivity::class.java.simpleName}_TAG", animal.toString())
        Toast.makeText(applicationContext, valueFromIntent, Toast.LENGTH_LONG).show()

        etShareContent = findViewById(R.id.etSharedContent)
    }

    fun onShareContent(view: View){
        val shareIntent = Intent().apply {
            setAction(Intent.ACTION_SEND)
            setType("text/plain")
            putExtra(Intent.EXTRA_TEXT, etShareContent.text.toString())
        }
        startActivity(shareIntent)
    }
}
