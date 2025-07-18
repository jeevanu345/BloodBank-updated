package com.example.bloodbank2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btnFindDonor = findViewById<Button>(R.id.btnFindDonor)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnDashboard = findViewById<Button>(R.id.btnDashboard)
        val btnFindHospitals = findViewById<Button>(R.id.btn_find_hospitals)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnFindDonor.setOnClickListener {
            val intent = Intent(this, FindDonor::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        btnDashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        btnFindHospitals.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=hospitals near me")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }
    }
}