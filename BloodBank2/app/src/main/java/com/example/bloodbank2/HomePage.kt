package com.example.bloodbank2

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)  // Make sure your XML file is named this way

        // Make sure these Button IDs exist in your activity_home_page.xml
        val btnFindDonor = findViewById<Button>(R.id.btnFindDonor)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnDashboard = findViewById<Button>(R.id.btnDashboard)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnFindDonor.setOnClickListener {
            val intent = Intent(this, FindDonor::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        btnDashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
