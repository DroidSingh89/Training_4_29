package com.example.training_4_29.threads

import android.os.AsyncTask
import android.util.Log
import com.example.training_4_29.manager.TaskManager

class MyAsyncTask(val callback:(Int)->Unit): AsyncTask<Int, Int, String>() {

    override fun onPreExecute() {
        super.onPreExecute()
        Log.d(MyAsyncTask::class.java.simpleName, "onPreExecute: ")
    }

    override fun doInBackground(vararg params: Int?): String {

        Log.d(MyAsyncTask::class.java.simpleName, "doInBackground: ")
        TaskManager.startTask(MyAsyncTask::class.java.simpleName, params[0] ?: 0) {
            publishProgress(it)
        }

        return "Complete"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        callback.invoke(values[0]?:0)

    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        Log.d(MyAsyncTask::class.java.simpleName, "onPostExecute: ${Thread.currentThread().name}"+ result)
    }
}