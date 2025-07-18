package com.example.bloodbank2

import android.content.Intent

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import dbContoller.dbController

class Profile : AppCompatActivity() {
    private lateinit var db: dbController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val etName = findViewById<EditText>(R.id.etName)
        val spinnerSex = findViewById<Spinner>(R.id.spinnerSex)
        val spinnerBlood = findViewById<Spinner>(R.id.spinnerBlood)
        val etContact = findViewById<EditText>(R.id.etContact)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val spinnerDivision = findViewById<Spinner>(R.id.spinnerDivision)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val checkBoxDonor = findViewById<CheckBox>(R.id.checkBoxDonor)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        db = dbController(this)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val sex = spinnerSex.selectedItem.toString()
            val bloodGroup = spinnerBlood.selectedItem.toString()
            val contact = etContact.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val division = spinnerDivision.selectedItem.toString()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            val isDonor = checkBoxDonor.isChecked

            // Basic validation
            if (name.isEmpty() || contact.isEmpty() || address.isEmpty() ||
                email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Insert into database
            val result = db.insertUser(
                name, sex, bloodGroup, contact, address,
                division, email, password, isDonor
            )

            if (result > 0) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomePage::class.java))
                finish()
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()  // Optional: closes current activity so it doesn't stay in back stack
        }

    }
}

