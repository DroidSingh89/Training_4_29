package com.example.training_4_29.manager

import android.content.Context
import android.provider.ContactsContract
import com.example.training_4_29.model.entities.Contact

object ProviderManager{

    fun retrieveContacts(applicationContext: Context, callback: (List<Contact>) -> Unit) {

        //URI
        val contactsUri = ContactsContract.Contacts.CONTENT_URI

        //Columns
        val DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME
        val HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER

        //retrieve using the content provider
        val contactCursor = applicationContext.contentResolver.query(
            contactsUri,
            null, null, null, null
        )

        val contactList = mutableListOf<Contact>()

        while (contactCursor.moveToNext()) {

            val contactName = contactCursor.getString(contactCursor.getColumnIndex(DISPLAY_NAME))

            val hasPhoneNumber = contactCursor.getInt(contactCursor.getColumnIndex(HAS_PHONE_NUMBER))

            if (hasPhoneNumber > 0) {

                val phoneNumbers = mutableListOf<String>()
                val phoneURI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                val NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER

                val phoneCursor = applicationContext.contentResolver.query(
                    phoneURI,
                    arrayOf(NUMBER),
                    "$DISPLAY_NAME =?",
                    arrayOf(contactName), "$NUMBER ASC"
                )

                while (phoneCursor.moveToNext()) {
                    val phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER))
                    phoneNumbers.add(phoneNumber)
                }
                contactList.add(Contact(contactName, phoneNumbers))

            }

        }
        callback.invoke(contactList)

    }
}