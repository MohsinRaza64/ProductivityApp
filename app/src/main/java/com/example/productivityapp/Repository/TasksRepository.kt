package com.example.productivityapp.Repository

import androidx.lifecycle.LiveData
import com.example.productivityapp.classes.Task
import com.example.productivityapp.classes.TaskDao
import kotlinx.coroutines.flow.Flow

class TasksRepository(val dao: TaskDao) {

    fun getAllTasks(): Flow<List<Task>> {
        return dao.getAllTasks()
    }
    fun insertTask(task: Task){
        dao.insert(task)
    }
    fun updateTask(task: Task){
        dao.update(task)
    }
    fun deleteTask(taskId: Int){
        dao.delete(taskId)
    }

}