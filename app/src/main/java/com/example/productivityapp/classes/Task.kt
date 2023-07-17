package com.example.productivityapp.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

var taskList = mutableListOf<Task>()
@Entity(tableName = "tasks")
class Task(
    var title: String,
    var description: String,
    var startTime: LocalTime,
    var endTime: LocalTime,
    var iconId: Int,
    var iconIdW: Int,
    var status: Boolean,
    @PrimaryKey(autoGenerate = true)
    var taskId: Int)
//{

//    fun getStartTime(): Time {
//        return startTime
//    }
//    fun setStartTime(startTime: Time){
//        this.startTime = startTime
//    }
//    fun getTitle(): String {
//        return title
//    }
//    fun setTitle(title: String){
//        this.title = title
//    }
//    fun getEndTime(): Time {
//        return endTime
//    }
//    fun setEndTime(endTime: Time){
//        this.endTime = endTime
//    }
//    fun getIconId(): String {
//        return iconId
//    }
//    fun setIconId(iconId: String){
//        this.iconId = iconId
//    }

//}