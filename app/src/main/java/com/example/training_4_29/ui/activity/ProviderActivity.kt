package com.example.training_4_29.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.manager.PermissionManager
import com.example.training_4_29.manager.ProviderManager
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_provider.*

class ProviderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provider)

        PermissionManager.checkContactPermission(this) { isGranted ->
            if (isGranted) printList()

        }

        btnGetContacts.setOnClickListener { printList() }
    }

    private fun printList() {
        ProviderManager.retrieveContacts(applicationContext)
        { contactList ->
            Log.d("ProviderActivity", "contactList: ${contactList.size}")
            contactList.forEach { toast(it.toString())
            Log.d("ProviderActivity", "Contact: ${it.toString()}")}
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.onPermissionResult(requestCode, permissions, grantResults)
        { isGranted ->
            if (isGranted) printList()
        }
    }
}
