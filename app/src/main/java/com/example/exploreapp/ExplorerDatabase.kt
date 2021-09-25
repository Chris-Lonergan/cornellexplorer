package com.example.exploreapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ExplorerEntities::class), version=1)
public abstract class ExplorerDatabase : RoomDatabase() {
    abstract fun explorerDao() : ExplorerDao

    companion object {
        @Volatile
        private var INSTANCE : ExplorerDatabase? = null

        fun getInstance(context : Context) : ExplorerDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, ExplorerDatabase::class.java, "explorer-database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
    val db = Room.databaseBuilder(applicationContext, ExplorerDatabase::class.java, "explorer-database").build()
    val explorerDao = db.explorerDao()
    val user : ExplorerEntities.User = explorerDao.getUserById(1)
    val totalActivities : Int = explorerDao.getTotalActivities()

}