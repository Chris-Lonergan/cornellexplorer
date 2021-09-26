package com.example.exploreapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExplorerDao {

    @Query("SELECT * FROM userWithActivities_table")
    fun getAllUsers(): List<ExplorerEntities.UserWithActivities>

    @Query("SELECT * FROM activities_table")
    fun getAllActivities(): List<ExplorerEntities.Activity>

    @Query("SELECT * FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserById(id: Int): ExplorerEntities.UserWithActivities

    @Query("SELECT experience FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserExperience(id: Int): Int

    @Query("SELECT level FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserLevel(id: Int): Int

    @Query("SELECT badges FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserBadges(id: Int): List<String>

    @Query("SELECT activities FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserActivities(id: Int): List<ExplorerEntities.Activity>

    @Insert
    fun createUser(
        username: String,
        level: Int,
        experience: Int,
        badges: List<String>,
        activities: List<ExplorerEntities.Activity>
    )

    @Insert
    fun createActivity(
        user_id: Int,
        image: String,
        location: String,
        difficulty: String,
        points: Int,
        description: List<String>,
        completion: Boolean,
        time: String
    )

    @Insert()
    fun updateCompletion(id: Int, status: Boolean)

    @Insert()
    fun updateExperience(uid: Int, level: Int)

    @Insert()
    fun updateLevel(uid: Int, level: Int)

    @Query("DELETE FROM userWithActivities_table WHERE uid IN (:id)")
    suspend fun deleteUser(id: Int): Int

    @Query("SELECT * FROM activities_table WHERE completion IS 1")
    fun getCompletedActivities(uid: Int): List<ExplorerEntities.Activity>

    @Query("SELECT * FROM activities_table WHERE completion IS 0")
    fun getIncompletedActivities(uid: Int): List<ExplorerEntities.Activity>
}