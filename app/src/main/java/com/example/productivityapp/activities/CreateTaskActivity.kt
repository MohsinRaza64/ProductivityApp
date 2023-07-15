package com.example.productivityapp.activities

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.productivityapp.R
import java.time.LocalTime
import java.util.Calendar

class CreateTaskActivity : AppCompatActivity() {
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

    }

    fun setStartTime(view: View) {
        val currentTime = Calendar.getInstance()
        val initHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val initMinute = currentTime.get(Calendar.MINUTE)
        TimePickerDialog(this, R.style.TimePickerDialog, { view, hour_of_day, minute ->
            stEditText.setText("$hour_of_day:$minute")
        }, initHour, initMinute, true).show()
    }

    fun setEndTime(view: View) {
        val currentTime = Calendar.getInstance()
        val initHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val initMinute = currentTime.get(Calendar.MINUTE)
        TimePickerDialog(this, R.style.TimePickerDialog, { view, hour_of_day, minute ->
            etEditText.setText("$hour_of_day:$minute")
        }, initHour, initMinute, true).show()
    }
}