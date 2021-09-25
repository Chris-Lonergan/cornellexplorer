package com.example.exploreapp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ExplorerRepository (private val explorerDao : ExplorerDao){

    val allActivities: Flow<List<ExplorerEntities.Activities>> = explorerDao.getUserActivities(1)

    @Suppress("RedundantSuspentModifier")
    @WorkerThread
    suspend fun updateCompletiion(status : Boolean) {
        explorerDao.updateCompletion(1, status)
    }
}