package com.example.bloodbank2

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<TextView>(R.id.appName)
        val getStarted = findViewById<Button>(R.id.btnGetStarted)

        // Load slower swoop animation (set duration longer in XML)
        val swoopAnim = AnimationUtils.loadAnimation(this, R.anim.swoop_in)

        // Start swoop animation on logo and app name (runs once)
        logo.startAnimation(swoopAnim)
        appName.startAnimation(swoopAnim)

        // Get Started button -> open Login screen with transition
        getStarted.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}