package com.example.exploreapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ActivityDao {

    @Query("SELECT * FROM activities_table")
    fun getAllActivities(): List<ActivityEntities>

    @Insert
    fun createActivity(
        user_id: Int,
        name : String,
        image: String,
        location: String,
        difficulty: String,
        points: Int,
        description: String,
        completion: Boolean,
        time: String
    )

    @Insert()
    fun updateCompletion(id: Int, status: Boolean)

//    @Query("SELECT * FROM activities_table WHERE completion IS 1")
//    fun getCompletedActivities(aid: Int): List<ActivityEntities>
//
//    @Query("SELECT * FROM activities_table WHERE completion IS 0")
//    fun getIncompletedActivities(aid: Int): List<ActivityEntities>

    @Query("DELETE FROM activities_table WHERE aid IN (:id)")
    suspend fun deleteActivity(id: Int): Int
}