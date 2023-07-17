package com.example.productivityapp.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.productivityapp.Repository.TasksRepository
import com.example.productivityapp.classes.Task
import com.example.productivityapp.classes.TaskRoomDatabase
import kotlinx.coroutines.flow.Flow

class TasksViewModel(application: Application): AndroidViewModel(application) {

    val taskRepository: TasksRepository

    init {

        val dao = TaskRoomDatabase.getDatabaseInstance(application)!!.taskDao()
        taskRepository = TasksRepository(dao)
    }

    fun addTasks(task: Task){
        taskRepository.insertTask(task)
    }

    fun updateTask(task: Task){
        taskRepository.updateTask(task)
    }

    fun getAllTasks(): Flow<List<Task>> = taskRepository.getAllTasks()

    fun deleteTask(taskId: Int){
        taskRepository.deleteTask(taskId)
    }

}