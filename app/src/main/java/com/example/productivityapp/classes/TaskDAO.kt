package com.example.productivityapp.classes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(taskId: Int)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>
}