package com.example.training_4_29.network

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class NativeHelper {

    lateinit var httpURLConnection: HttpURLConnection

    fun makeRequest(url: String):String{
        val result = StringBuilder()
        try {

            val URL = URL(url)
            httpURLConnection = URL.openConnection() as HttpURLConnection
            val inputSteam = httpURLConnection.inputStream as InputStream

            val scanner = Scanner(inputSteam)


            while (scanner.hasNext()) result.append(scanner.nextLine())

        }
        catch (e: IOException){
            e.printStackTrace()
        }
        return result.toString()

    }
}