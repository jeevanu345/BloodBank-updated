package com.example.bloodbank2

import android.content.Intent

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FindDonor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_donor)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val btnFindDonor = findViewById<Button>(R.id.btnFindDonor)
        val bloodGroupInput = findViewById<EditText>(R.id.bloodGroup)
        val divisionInput = findViewById<EditText>(R.id.division)

        homeIcon.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        btnFindDonor.setOnClickListener {
            val bloodGroup = bloodGroupInput.text.toString().trim()
            val division = divisionInput.text.toString().trim()
            if (bloodGroup.isEmpty() || division.isEmpty()) {
                Toast.makeText(this, "Please enter both blood group and division", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Dashboard::class.java).apply {
                putExtra("bloodGroup", bloodGroup)
                putExtra("division", division)
            }
            startActivity(intent)
        }
    }
}

