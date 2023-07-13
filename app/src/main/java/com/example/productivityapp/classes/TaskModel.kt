package com.example.productivityapp.classes

import java.sql.Time

class TaskModel(
    private var title: String,
    private var startTime: Time,
    private var endTime: Time,
    private var iconId: String) {

    fun getStartTime(): Time {
        return startTime
    }
    fun setStartTime(startTime: Time){
        this.startTime = startTime
    }
    fun getTitle(): String {
        return title
    }
    fun setTitle(title: String){
        this.title = title
    }
    fun getEndTime(): Time {
        return endTime
    }
    fun setEndTime(endTime: Time){
        this.endTime = endTime
    }
    fun getIconId(): String {
        return iconId
    }
    fun setIconId(iconId: String){
        this.iconId = iconId
    }

}