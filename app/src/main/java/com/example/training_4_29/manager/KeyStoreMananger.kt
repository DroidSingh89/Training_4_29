package com.example.training_4_29.manager

import android.content.Context
import android.security.KeyPairGeneratorSpec
import java.math.BigInteger
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.PrivateKey
import java.util.*
import javax.security.auth.x500.X500Principal

class KeyStoreMananger(val context: Context) {

    val KEYSTORE_PROVIDER = "AndroidKeyStore"
    val ALGORITHM = "RSA"
    val keystore = KeyStore.getInstance(KEYSTORE_PROVIDER)
    val keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM, KEYSTORE_PROVIDER)

    fun createKeyPair(alias: String): KeyPair {

        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        val spec = KeyPairGeneratorSpec.Builder(context)
            .setAlias(alias)
            .setSerialNumber(BigInteger.ONE)
            .setSubject(X500Principal("CN={alias} CA Certificate"))
            .setStartDate(startDate.time)
            .setEndDate(endDate.time)
            .build()

        //val spec2 = KeyGenParameterSpec.Builder(context)

        keyPairGenerator.initialize(spec)
        return keyPairGenerator.generateKeyPair()
    }

    fun getKeyPair(alias: String): KeyPair {
        val privateKey: PrivateKey = keystore.getKey(alias, null) as PrivateKey
        val publicKey = keystore.getCertificate(alias).publicKey
        return KeyPair(publicKey, privateKey)

    }
    fun removeKeyPair(alias: String) = keystore.deleteEntry(alias)

}