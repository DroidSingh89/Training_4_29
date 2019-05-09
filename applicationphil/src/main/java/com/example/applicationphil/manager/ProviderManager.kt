package com.example.applicationphil.manager

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract
import com.example.applicationphil.model.entities.Contact

object ProviderManager {

    fun retrieveContacts(context: Context, callback: (List<Contact>) -> Unit) {

        val contactsUri: Uri = ContactsContract.Contacts.CONTENT_URI

        val DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME
        val HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER

        val contactCursor = context.contentResolver.query(contactsUri,
            null, null, null, null)

        val contactList = mutableListOf<Contact>()

        while(contactCursor.moveToNext()){

            val contactName = contactCursor.getString(contactCursor.getColumnIndex(DISPLAY_NAME))
            val hasPhoneNumber = contactCursor.getInt(contactCursor.getColumnIndex(HAS_PHONE_NUMBER))

            if(hasPhoneNumber>0){

                val phoneNumbers = mutableListOf<String>()
                val phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                val NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER

                val phoneCursor = context.contentResolver.query(
                    phoneUri,
                    arrayOf(NUMBER),
                    "$DISPLAY_NAME =?",
                    arrayOf(contactName),
                    "$NUMBER ASC"
                )

                while(phoneCursor.moveToNext()){
                    val phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER))
                    phoneNumbers.add(phoneNumber)
                }
                contactList.add(Contact(contactName, phoneNumbers))
            }

        }
        callback.invoke(contactList)
    }
}