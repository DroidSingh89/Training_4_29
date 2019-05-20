package com.example.training_4_29.manager

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("StaticFieldLeak")
object LoginManager {
    lateinit var context: Context
    val auth = FirebaseAuth.getInstance()

    fun checkSession(): Boolean = auth.currentUser != null

    fun createUser(email: String, password: String, callback: (Boolean) -> Unit) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                taskResults(task, callback)
            }
    }

    fun signIn(email: String, password: String, callback: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                taskResults(task, callback)
            }

    }

    fun signOut(callback: (Boolean) -> Unit) {
        auth.signOut()
        callback.invoke(true)
        //context.toast("signed out")
    }

    var taskResults: (Task<AuthResult>, (Boolean) -> Unit) -> Unit = { task, callback ->
        if (task.isSuccessful) callback.invoke(true)
        else callback.invoke(false)
    }
}