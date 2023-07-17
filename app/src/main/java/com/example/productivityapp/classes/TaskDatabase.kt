package com.example.productivityapp.classes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Task::class], version = 1)
abstract class TaskRoomDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object
    {
        @Volatile
        var INSTANCE: TaskRoomDatabase?= null
        fun getDatabaseInstance(context: Context): TaskRoomDatabase? {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val roomDatabaseInstance = Room.databaseBuilder(context, TaskRoomDatabase::class.java, "TasksDB").build()
                INSTANCE = roomDatabaseInstance
                return INSTANCE
            }
        }
    }
}