package com.anshu.wedin.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) :
   SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
       companion object{
          private const val DATABASE_NAME = "WedingDatabase"
          private const val DATABASE_VERSION = 1
          private const val TABLE_WED = "WedingTable"

           private const val KEY_ID = "_id"
           private const val KEY_PASSWORD = "password"
           private const val KEY_MOBILE = "mobile"
           private const val KEY_USER = "user"
       }

    override fun onCreate(db: SQLiteDatabase?) {
        val WEDDIN = ("CREATE TABLE " + TABLE_WED +
                                     KEY_ID + " INTEGER PRIMARY KEY,"
                                    + KEY_MOBILE + " TEXT,"
                                    + KEY_PASSWORD + " TEXT,"
                                    + KEY_USER + " TEXT)" )
        db?.execSQL(WEDDIN)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_WED")
        onCreate(db)
    }
    fun addWedding(wedding: DataEvent): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, wedding.id)
        contentValues.put(KEY_MOBILE, wedding.mobile)
        contentValues.put(KEY_PASSWORD, wedding.password)
        contentValues.put(KEY_USER, wedding.user)

        val result = db.insert(TABLE_WED, null, contentValues)
        db.close()
        return result
    }
}