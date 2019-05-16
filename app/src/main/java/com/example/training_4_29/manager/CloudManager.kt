package com.example.training_4_29.manager

import android.annotation.SuppressLint
import android.content.Context
import com.example.training_4_29.utils.toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@SuppressLint("StaticFieldLeak")
object CloudManager{


    lateinit var context: Context

    val database = FirebaseDatabase.getInstance()
    val simpleDataRef = database.getReference("simpledata")

    fun saveFirebaseData(value: String){

        simpleDataRef.setValue(value)
            .addOnCompleteListener { context.toast(it.isSuccessful.toString()) }
    }

    fun readFirebaseData(callback: (String) -> Unit){


        simpleDataRef.addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                context.toast("Single change: ${snapshot.getValue(String::class.java)}")
            }

        })
        simpleDataRef.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                context.toast("Every change: ${snapshot.getValue(String::class.java)}")

            }

        })


    }

}