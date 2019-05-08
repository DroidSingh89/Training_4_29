package com.example.applicationphil.model.data.sqlite

import android.provider.BaseColumns

object PersonContract {

    const val VERSION_NUMBER: Int = 1
    const val DATABASE_NAME = "Person.db"

    object FeedEntry : BaseColumns{

        const val TABLE_NAME = "Person"
        const val COLUMN_NAME = "Name"
        const val COLUMN_AGE = "Age"
        const val COLUMN_GENDER = "Gender"
    }

    object Query {

        const val SQL_CREATE_ENTRIES =
                "CREATE TABLE ${PersonContract.FeedEntry.TABLE_NAME} (" +
                        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                        "${PersonContract.FeedEntry.COLUMN_NAME} TEXT," +
                        "${PersonContract.FeedEntry.COLUMN_AGE} INTEGER," +
                        "${PersonContract.FeedEntry.COLUMN_GENDER} TEXT)"

        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${PersonContract.FeedEntry.TABLE_NAME}"

        const val SQL_GET_PEOPLE = "SELECT * FROM ${PersonContract.FeedEntry.TABLE_NAME}"

    }
}