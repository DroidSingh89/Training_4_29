package com.example.training_4_29.manager

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


const val CLICK_ID = 1

object AnalyticsManager {

    lateinit var firebaseAnalytics: FirebaseAnalytics

    fun init(context: Context){
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun logEvent(eventname: String, eventID:String, contentType: String){

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, eventID)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, eventname)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }


}