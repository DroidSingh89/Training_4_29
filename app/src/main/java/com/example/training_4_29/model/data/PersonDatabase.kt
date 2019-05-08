package com.example.training_4_29.model.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.training_4_29.kotlinReview.Person

class PersonDatabase(context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(PersonContract.Query.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun savePerson(person: Person) {

        val contentValue = ContentValues()

        contentValue.put(PersonContract.FeedEntry.COLUMN_NAME, person.name)
        contentValue.put(PersonContract.FeedEntry.COLUMN_AGE, person.age)
        contentValue.put(PersonContract.FeedEntry.COLUMN_GENDER, person.gender)

        writableDatabase.insert(PersonContract.FeedEntry.TABLE_NAME, null, contentValue)
        writableDatabase.close()

    }

    fun getAllPerson(): List<Person> {

        val mutablePersonList = ArrayList<Person>()
        writableDatabase.rawQuery(PersonContract.Query.SQL_GET_PEOPLE, null)
            .apply {
                if (moveToFirst()) {
                    do {
                        mutablePersonList.add(
                            Person(
                                getString(getColumnIndex(PersonContract.FeedEntry.COLUMN_NAME)),
                                getInt(getColumnIndex(PersonContract.FeedEntry.COLUMN_AGE)),
                                getString(getColumnIndex(PersonContract.FeedEntry.COLUMN_GENDER))
                            )
                        )
                    } while (moveToNext())
                } else {
                    return emptyList()
                }
            }
        return mutablePersonList
    }


}