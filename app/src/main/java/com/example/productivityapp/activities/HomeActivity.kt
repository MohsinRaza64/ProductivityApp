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
//    private var tvTest: TextView? = null
    /*
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

    val titleN: String = title?:""
    val descriptionN: String = description?:""
    val startTimeN: LocalTime = startTime?: LocalTime.MIDNIGHT
    val endTimeN: LocalTime = endTime?: LocalTime.MIDNIGHT
    val iconIdN: Int = iconId?: 0
    val iconIdWN: Int = iconIdW?: 0
    val statusN: Boolean = status?: true

    val returnedtask = Task(
    titleN,
    descriptionN,
    startTimeN,
    endTimeN,
    iconIdN,
    iconIdWN,
    statusN
    )
    tvTest?.text = returnedtask.title
    taskList.add(returnedtask)
    }
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var rvTasks = findViewById<RecyclerView>(R.id.rvTasks)
//        tvTest = findViewById(R.id.textViewTest)
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