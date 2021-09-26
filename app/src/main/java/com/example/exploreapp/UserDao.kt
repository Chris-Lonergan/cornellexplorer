package com.example.exploreapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<UserEntities>

    @Query("SELECT * FROM user_table WHERE uid IN (:id)")
    fun getUserById(id: Int): UserEntities

    @Query("SELECT experience FROM user_table WHERE uid IN (:id)")
    fun getUserExperience(id: Int): Int

    @Query("SELECT level FROM user_table WHERE uid IN (:id)")
    fun getUserLevel(id: Int): Int

    @Query("SELECT badges FROM user_table WHERE uid IN (:id)")
    fun getUserBadges(id: Int): List<String>

    @Query("SELECT completed FROM user_table WHERE uid IN (:id)")
    fun getUserCompletedActivities(id: Int): List<ActivityEntities>

    @Insert
    fun createUser(
        username: String,
        level: Int,
        experience: Int,
        badges: List<String>,
        completed : List<String>
    )

    @Insert()
    fun updateExperience(uid: Int, level: Int)

    @Insert()
    fun updateLevel(uid: Int, level: Int)

    @Query("DELETE FROM user_table WHERE uid IN (:id)")
    suspend fun deleteUser(id: Int): Int
}