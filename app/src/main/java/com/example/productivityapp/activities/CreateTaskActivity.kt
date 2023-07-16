package com.example.productivityapp.activities

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.productivityapp.R
import com.example.productivityapp.classes.Task
import java.time.LocalTime
import java.util.Calendar
import com.example.productivityapp.classes.taskList


class CreateTaskActivity : AppCompatActivity() {
    private  lateinit var titleEditTextm: EditText
    private lateinit var descriptionEditTextm: EditText
    private lateinit var stEditText : EditText
    private lateinit var etEditText : EditText

    //Data variables
    lateinit var startTimeS : LocalTime
    lateinit var endTimeS : LocalTime
    var iconIdS : Int = 0
    var iconIdWS : Int = 0
    var statusS : Boolean = false
    //////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        stEditText = findViewById(R.id.startTimeEditText)
        etEditText = findViewById(R.id.endTimeEditText)
        titleEditTextm = findViewById(R.id.titleEditText)
        descriptionEditTextm = findViewById(R.id.descriptionEditText)


        //Giving Default values in case user doesn't use the time pickers.
        startTimeS = LocalTime.of(0, 0)
        endTimeS = LocalTime.of(0, 0)

    }



    fun setStartTime(view: View) {
        val currentTime = Calendar.getInstance()
        val initHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val initMinute = currentTime.get(Calendar.MINUTE)
        TimePickerDialog(this, R.style.TimePickerDialog, { view, hour_of_day, minute ->
            stEditText.setText("$hour_of_day:$minute")
            startTimeS = LocalTime.of(hour_of_day, minute)
        }, initHour, initMinute, true).show()
    }

    fun setEndTime(view: View) {
        val currentTime = Calendar.getInstance()
        val initHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val initMinute = currentTime.get(Calendar.MINUTE)
        TimePickerDialog(this, R.style.TimePickerDialog, { view, hour_of_day, minute ->

            etEditText.setText("$hour_of_day:$minute")
            endTimeS = LocalTime.of(hour_of_day, minute)
        }, initHour, initMinute, true).show()
    }
    fun addDataToArray(view: View) {
        var title = titleEditTextm.text.toString()
        var description = descriptionEditTextm.text.toString()

        var task = Task(
            title,
            description,
            startTimeS,
            endTimeS,
            R.drawable.bike,
            R.drawable.bikew,
            true
        )
        taskList.add(task)
        /*
        Toast.makeText(applicationContext, "${task.title} ${task.taskId} ${task.status} ${task.endTime} ${task.iconId} ${task.startTime} ${task.iconIdW} ${task.description} ", Toast.LENGTH_SHORT).show()
        val intent = Intent()
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        val startTimeString: String = startTimeS.toString()
        intent.putExtra("startTimeS", startTimeString)
        val endTimeString: String = endTimeS.toString()
        intent.putExtra("endTimeS", endTimeString)
        intent.putExtra("iconId", R.drawable.bike)
        intent.putExtra("iconIdW", R.drawable.bikew)
        intent.putExtra("status", true)

        setResult(RESULT_OK, intent)
        */
        finish()
    }
}


// Created Result Intent: https://youtu.be/UM3J2jWJre0