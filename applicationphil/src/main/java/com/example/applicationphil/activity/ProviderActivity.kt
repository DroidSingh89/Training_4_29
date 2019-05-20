package com.example.applicationphil.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationphil.BaseActivity
import com.example.applicationphil.R
import com.example.applicationphil.manager.PermissionManager
import com.example.applicationphil.manager.ProviderManager
import com.example.applicationphil.util.toast

class ProviderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provider)

        PermissionManager.checkContactPermission(this) { granted ->
            if (granted) printContactList()
        }
    }

    private fun printContactList() {
        ProviderManager.retrieveContacts(applicationContext){ contactList ->
            contactList.forEach{ toast(it.name) }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.onPermissionResult(
            requestCode,
            permissions,
            grantResults
        ) { granted ->
            if (granted) printContactList()
        }
    }
}
