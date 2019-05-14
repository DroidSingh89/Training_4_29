package com.example.training_4_29.service

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.training_4_29.manager.TaskManager

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.training_4_29.service.action.FOO"
private const val ACTION_BAZ = "com.example.training_4_29.service.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.example.training_4_29.service.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.training_4_29.service.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class MyIntentService : IntentService("MyIntentService") {

    override fun onCreate() {
        super.onCreate()
        Log.d(MyIntentService::class.java.simpleName, "onCreate: ")
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.d(MyIntentService::class.java.simpleName, "onStart: ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(MyIntentService::class.java.simpleName, "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(MyIntentService::class.java.simpleName, "onHandleIntent: ${intent?.action}")
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionFoo(param1, param2)
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionBaz(param1, param2)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MyIntentService::class.java.simpleName, "onDestroy: ")
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        Log.d(MyIntentService::class.java.simpleName, "handleActionFoo: $param1 $param2")
        TaskManager.startTask("FooAction", 5){}
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        Log.d(MyIntentService::class.java.simpleName, "handleActionBaz: $param1 $param2")
        TaskManager.startTask("BazAction", 5){}
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}
