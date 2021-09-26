package com.example.exploreapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ActivityEntities::class), version=1)
public abstract class ActivityDatabase : RoomDatabase() {
    abstract fun activityDao() : ActivityDao

    companion object Activity {
        @Volatile
        private var INSTANCE : ActivityDatabase? = null

        fun getInstance(context : Context) : ActivityDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, ActivityDatabase::class.java, "activity-database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}