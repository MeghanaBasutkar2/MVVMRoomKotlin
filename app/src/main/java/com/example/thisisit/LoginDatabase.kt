package com.example.thisisit

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LoginTableModel::class], version = 1, exportSchema = false)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun loginDao(): DaoAccess //1 - holds reference to dao

    companion object { //2 - has the db instance
        private var INSTANCE: LoginDatabase? = null

        fun getLoginDBInstance(context: Context): LoginDatabase? {
            if (INSTANCE != null) {
                return INSTANCE
            } else {
                INSTANCE =
                    Room.databaseBuilder(context, LoginDatabase::class.java, "LOGIN_DATABASE")
                        .fallbackToDestructiveMigration()
                        .build()

                return INSTANCE!!
            }
        }
    }
}