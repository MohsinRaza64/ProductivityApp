package com.example.productivityapp.activities

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.productivityapp.R
import java.util.Calendar

class CreateTaskActivity : AppCompatActivity() {
    private lateinit var stEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        stEditText = findViewById(R.id.startTimeEditText)

    }

    fun setStartTime(view: View) {
        val currentTime = Calendar.getInstance()
        val initHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val initMinute = currentTime.get(Calendar.MINUTE)
        TimePickerDialog(this, { view, hour_of_day, minute ->
            stEditText.setText("$hour_of_day:$minute")
        }, initHour, initMinute, true).show()
    }
}