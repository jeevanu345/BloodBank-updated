package com.example.bloodbank2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FindDonor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_donor)

        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val btnFindDonor = findViewById<Button>(R.id.btnFindDonor)
        val bloodGroupSpinner = findViewById<Spinner>(R.id.spinnerBloodGroup)
        val divisionSpinner = findViewById<Spinner>(R.id.spinnerDivision)

        // Spinner data
        val bloodGroupList = arrayOf("Choose Blood Group", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-")
        val divisionList = arrayOf(
            "Select City",
            "Mumbai",
            "Delhi",
            "Bengaluru",
            "Hyderabad",
            "Ahmedabad",
            "Chennai",
            "Kolkata",
            "Pune",
            "Jaipur",
            "Surat",
            "Lucknow",
            "Kanpur",
            "Nagpur",
            "Indore"
        )
        // Blood group adapter with hint behavior
        val bloodGroupAdapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bloodGroupList) {
            override fun isEnabled(position: Int): Boolean = position != 0
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val textView = view as TextView
                textView.setTextColor(if (position == 0) Color.GRAY else Color.BLACK)
                return view
            }
        }

        // Division adapter with hint behavior
        val divisionAdapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, divisionList) {
            override fun isEnabled(position: Int): Boolean = position != 0
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val textView = view as TextView
                textView.setTextColor(if (position == 0) Color.GRAY else Color.BLACK)
                return view
            }
        }

        bloodGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        divisionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        bloodGroupSpinner.adapter = bloodGroupAdapter
        divisionSpinner.adapter = divisionAdapter

        // Home icon click listener
        homeIcon.setOnClickListener {
            startActivity(Intent(this, HomePage::class.java))
        }

        // Search button click listener
        btnFindDonor.setOnClickListener {
            val selectedBloodGroup = bloodGroupSpinner.selectedItem.toString()
            val selectedDivision = divisionSpinner.selectedItem.toString()

            if (selectedBloodGroup == "Choose Blood Group" || selectedDivision == "Choose Division") {
                Toast.makeText(this, "Please select both blood group and division", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Dashboard::class.java).apply {
                putExtra("bloodGroup", selectedBloodGroup)
                putExtra("division", selectedDivision)
            }
            startActivity(intent)
        }
    }
}
