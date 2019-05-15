package com.example.training_4_29.utils

import android.util.Log
import com.example.training_4_29.model.entities.RandomUser.RandomUserResponse
import com.google.gson.Gson
import org.json.JSONObject

object Parser {

    fun gsonParser(response: String?): RandomUserResponse{
        return Gson().fromJson(response, RandomUserResponse::class.java)
    }

    fun nativeParser(response: String?){

        val rootObject = JSONObject(response)
        val results = rootObject.getJSONArray("results")
        val result_0 = results.get(0) as JSONObject
        val gender = result_0.getString("gender")
        Log.d(Parser::class.java.simpleName, "nativeParser: $gender")
    }


}