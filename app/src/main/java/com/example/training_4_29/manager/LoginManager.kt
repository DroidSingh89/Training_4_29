package com.example.training_4_29.manager

import android.annotation.SuppressLint
import android.content.Context
import com.example.training_4_29.utils.toast
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("StaticFieldLeak")
object LoginManager {
    lateinit var context: Context
    val auth = FirebaseAuth.getInstance()

    fun checkSession(): Boolean = auth.currentUser != null

    fun createUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) context.toast("user created")
                else context.toast("user not created because ${task.exception}")
            }
    }

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) context.toast("signed in")
                else context.toast("invalid credentials")
            }

    }

    fun signOut() {
        auth.signOut()
        context.toast("signed out")
    }
}