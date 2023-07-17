package com.example.productivityapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
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
        var addBtn = findViewById<ImageView>(R.id.imageViewAddButton)

        addBtn.setOnClickListener(){

        val intent = Intent(this@HomeActivity, CreateTaskActivity::class.java)
        startActivity(intent)
//        resultLauncher.launch(intent)
        }

        val adapter = TaskAdapter(taskList)
        rvTasks.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.layoutManager = linearLayoutManager
    }

    private fun populateTasks() {

        val task4 = Task(
            "Development",
            "Description",
            LocalTime.of(16,20, ),
            LocalTime.of(20, 50),
            R.drawable.bike,
            R.drawable.bikew,
            true,
            1
        )
        taskList.add(task4)
    }


    fun reStart(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
    fun onHomeButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
        populateTasks()
    }
//    fun onAddButtonClick(view: View){
//
//        val intent = Intent(this, CreateTaskActivity::class.java)
//        startActivity(intent)
//    }
    fun onSettingButtonClick(view: View){
        startActivity(Intent(this,SplashScreen::class.java))
    }
}