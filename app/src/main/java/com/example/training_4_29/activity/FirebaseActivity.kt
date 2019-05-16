package com.example.training_4_29.activity

import android.os.Bundle
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.manager.CloudManager
import com.example.training_4_29.manager.LoginManager
import kotlinx.android.synthetic.main.activity_firebase.*

class FirebaseActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        btnCreateUser.setOnClickListener {
            LoginManager.createUser(etEmail.text.toString(), etPassword.text.toString())
        }

        btnSignIn.setOnClickListener {
            LoginManager.signIn(etEmail.text.toString(), etPassword.text.toString())
        }

        btnSignOut.setOnClickListener { LoginManager.signOut() }



        //reading data  for firebase
        btnFirebaseSave.setOnClickListener {
            CloudManager.saveFirebaseData(etFirebaseData.text.toString())
        }

        btnFirebaseRead.setOnClickListener {
            CloudManager.readFirebaseData {  }
        }
    }

    override fun onStart() {
        super.onStart()
        if(LoginManager.checkSession()) tvLoginStatus.text = "Signed in"
    }
}
