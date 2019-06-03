package com.example.training_4_29.ui.activity

import android.os.Bundle
import com.example.training_4_29.R
import com.example.training_4_29.manager.CipherManager
import com.example.training_4_29.manager.KeyStoreMananger
import com.example.training_4_29.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_encryption.*
import java.security.KeyPair

class EncryptionActivity : BaseActivity() {

    private val keystoreManager = KeyStoreMananger(this)

    private val cipherManager = CipherManager()
    lateinit var keyPair: KeyPair
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encryption)

        keyPair = keystoreManager.createKeyPair("Training")

        btnEncryptText.setOnClickListener {
            tvEncryptedText.text = cipherManager.encrypt(etPlainText.text.toString(), keyPair.public)
        }

        btnDecryptText.setOnClickListener {
            tvPlainText.text = cipherManager.decrypt(tvEncryptedText.text.toString(), keyPair.private)
        }
    }
}
