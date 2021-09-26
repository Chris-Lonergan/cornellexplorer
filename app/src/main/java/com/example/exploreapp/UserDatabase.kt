package com.example.exploreapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UserEntities::class), version=1)
public abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object User {
        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context : Context) : UserDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user-database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}