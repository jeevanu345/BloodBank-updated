package com.example.bloodbank2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import dbContoller.dbController

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val searchIcon = findViewById<ImageView>(R.id.searchIcon)

        val donorListContainer = findViewById<LinearLayout>(R.id.donorListContainer)

        homeIcon.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        searchIcon.setOnClickListener {
            val intent = Intent(this, FindDonor::class.java)
            startActivity(intent)
        }



        val bloodGroup = intent.getStringExtra("bloodGroup") ?: ""
        val division = intent.getStringExtra("division") ?: ""

        val db = dbController(this)
        val donors = if (bloodGroup.isNotEmpty() && division.isNotEmpty()) {
            db.getDonorsByBloodAndDivision(bloodGroup, division)
        } else {
            db.getAllDonors()  // You'll need to implement this
        }

        for (donor in donors) {
            val card = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(16, 16, 16, 16)
                setBackgroundResource(android.R.color.white)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(8, 8, 8, 8)
                layoutParams = params
                isClickable = true
                isFocusable = true
            }

            val nameText = TextView(this).apply {
                text = "Donor: ${donor["name"]}"
                textSize = 18f
                setPadding(0, 0, 0, 4)
            }

            val contactText = TextView(this).apply {
                text = "Contact: ${donor["contact"]}"
            }

            val locationText = TextView(this).apply {
                text = "From: ${donor["address"]}"
            }

            card.addView(nameText)
            card.addView(contactText)
            card.addView(locationText)

            card.setOnClickListener {
                val intent = Intent(this, PatientDetails::class.java).apply {
                    donor.forEach { (key, value) -> putExtra(key, value) }
                }
                startActivity(intent)
            }

            donorListContainer.addView(card)
        }

    }

}

