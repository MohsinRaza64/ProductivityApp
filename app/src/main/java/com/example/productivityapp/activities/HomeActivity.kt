package com.example.productivityapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.productivityapp.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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