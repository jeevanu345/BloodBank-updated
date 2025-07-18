package com.example.bloodbank2


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PatientDetails : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_details)
        val backButton = findViewById<ImageView>(R.id.backButton)

        backButton.setOnClickListener {
            onBackPressed()  // This navigates to the previous activity
        }
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val bloodGroup = intent.getStringExtra("blood_group")
        val contact = intent.getStringExtra("contact")
        val address = intent.getStringExtra("address")
        val division = intent.getStringExtra("division")
        val sex = intent.getStringExtra("sex")

        // Set the values to TextViews (make sure you have these IDs in your XML)
        findViewById<TextView>(R.id.fullName)?.text = "Name: $name"
        findViewById<TextView>(R.id.email)?.text = "Email: $email"
        findViewById<TextView>(R.id.bloodGroup)?.text = "Blood Group: $bloodGroup"
        findViewById<TextView>(R.id.contact)?.text = "Contact: $contact"
        findViewById<TextView>(R.id.address)?.text = "Address: $address"
        findViewById<TextView>(R.id.division)?.text = "Division: $division"
        findViewById<TextView>(R.id.gender)?.text = "Gender: $sex"
    }
}


