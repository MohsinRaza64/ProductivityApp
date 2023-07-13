package com.example.productivityapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.productivityapp.R
import com.example.productivityapp.classes.Task
import com.example.productivityapp.classes.taskList
import java.time.LocalTime

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        populateTasks()

        val msg = " Task 1 is: ${taskList[1].taskId} and Task 2 is: ${taskList[0].endTime}"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
    private fun populateTasks() {
        val task1 = Task(
            "Exercise",
            LocalTime.of(9, 0),
            LocalTime.of(10, 0),
            R.drawable.bike,
            true
        )
        taskList.add(task1)
        val task2 = Task(
            "work",
            LocalTime.of(10, 0),
            LocalTime.of(11, 0),
            R.drawable.bike,
            false
        )
        taskList.add(task2)
    }


    fun reStart(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
    fun onHomeButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
    fun onAddButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
    fun onSettingButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
}