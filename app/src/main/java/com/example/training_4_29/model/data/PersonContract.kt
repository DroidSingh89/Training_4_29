package com.example.training_4_29.model.data

import android.provider.BaseColumns


object PersonContract {

    object FeedEntry: BaseColumns {

        const val TABLE_NAME = "person"
        const val COLUMN_NAME = "name"
        const val COLUMN_AGE = "age"
        const val COLUMN_GENDER = "gender"
    }
    object Query {

        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${FeedEntry.COLUMN_NAME} TEXT," +
                    "${FeedEntry.COLUMN_AGE} INTEGER," +
                    "${FeedEntry.COLUMN_GENDER} TEXT)"

        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"

        const val SQL_GET_PEOPLE = "SELECT * FROM ${FeedEntry.TABLE_NAME}"

    }
}
