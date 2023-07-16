package com.example.productivityapp.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productivityapp.R
import com.example.productivityapp.classes.Task
import com.example.productivityapp.classes.TaskAdapter
import com.example.productivityapp.classes.taskList
import java.time.LocalTime

class HomeActivity : AppCompatActivity() {
    private var tvTest: TextView? = null

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val title: String? = data?.getStringExtra("title")
            val description: String? = data?.getStringExtra("description")
            val startTimeString: String? = data?.getStringExtra("startTimeS")
            val startTime: LocalTime? = startTimeString?.let { LocalTime.parse(it) }
            val endTimeString: String? = data?.getStringExtra("endTimeS")
            val endTime: LocalTime? = endTimeString?.let { LocalTime.parse(it) }
            val iconId: Int? = data?.getIntExtra("iconId", 0)
            val iconIdW: Int? = data?.getIntExtra("iconIdW",0)
            val status: Boolean? = data?.getBooleanExtra("status", false)

            tvTest?.text = status.toString()

//            val returnedtask = Task(
//                title,
//                description,
//                startTime,
//                endTime,
//                iconId,
//                iconIdW,
//                status
//            )

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var rvTasks = findViewById<RecyclerView>(R.id.rvTasks)
        tvTest = findViewById(R.id.textViewTest)
        var addBtn = findViewById<ImageView>(R.id.imageViewAddButton)

        addBtn.setOnClickListener(){

        val intent = Intent(this@HomeActivity, CreateTaskActivity::class.java)
        resultLauncher.launch(intent)
        }

        val adapter = TaskAdapter(taskList)
        rvTasks.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.layoutManager = linearLayoutManager
    }
    private fun populateTasks() {
        val task1 = Task(
            "Exercise",
            "Description",
            LocalTime.of(9, 0),
            LocalTime.of(10, 0),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task1)
        val task2 = Task(
            "work",
            "Description",
            LocalTime.of(10, 0),
            LocalTime.of(16, 0),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task2)
        val task3 = Task(
            "Lunch",
            "Description",
            LocalTime.of(16, 0),
            LocalTime.of(16, 20),
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task3)
        val task4 = Task(
            "Development",
            "Description",
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