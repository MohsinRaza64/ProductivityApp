package com.example.productivityapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productivityapp.R
import com.example.productivityapp.classes.Task
import com.example.productivityapp.classes.TaskAdapter
import com.example.productivityapp.classes.taskList
import java.time.LocalTime

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var rvTasks = findViewById<RecyclerView>(R.id.rvTasks)


        val adapter = TaskAdapter(taskList)
        rvTasks.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.layoutManager = linearLayoutManager
    }
    private fun populateTasks() {
        val task1 = Task(
            "Exercise",
            LocalTime.of(9, 0),
            LocalTime.of(10, 0),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task1)
        val task2 = Task(
            "work",
            LocalTime.of(10, 0),
            LocalTime.of(16, 0),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task2)
        val task3 = Task(
            "Lunch",
            LocalTime.of(16, 0),
            LocalTime.of(16, 20),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task3)
        val task4 = Task(
            "Development",
            LocalTime.of(16,20, ),
            LocalTime.of(20, 50),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task4)
    }


    fun reStart(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
    fun onHomeButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
    fun onAddButtonClick(view: View){
        populateTasks()
        startActivity(Intent(this,CreateTaskActivity::class.java))
    }
    fun onSettingButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
}