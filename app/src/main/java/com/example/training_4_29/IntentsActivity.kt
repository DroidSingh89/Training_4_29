package com.example.training_4_29

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.training_4_29.KotlinReview.Animal
import com.example.training_4_29.KotlinReview.Person

class IntentsActivity : BaseActivity() {

    lateinit var etShareContent: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        etShareContent = findViewById(R.id.etShareContent)
        val valueFromIntent: String? = intent.getStringExtra("someKey") ?: "no Value"

        val person = intent.getSerializableExtra("person") as Person
        val animal = intent.getParcelableExtra("animal") as Animal
        Log.d("${IntentsActivity::class.java.simpleName}_TAG", person.toString())
        Log.d("${IntentsActivity::class.java.simpleName}_TAG", animal.toString())
        Toast.makeText(applicationContext, valueFromIntent, Toast.LENGTH_SHORT).show()

    }

    fun onShareContent(view: View) {

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, etShareContent.text.toString())
        }
        startActivity(shareIntent)
    }
}
