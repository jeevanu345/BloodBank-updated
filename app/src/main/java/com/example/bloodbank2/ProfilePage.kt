package com.example.bloodbank2

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dbContoller.dbController


class ProfilePage : AppCompatActivity() {

    companion object {
        const val EDIT_PROFILE_REQUEST_CODE = 1
    }

    private lateinit var fullNameTV: TextView
    private lateinit var genderTV: TextView
    private lateinit var ageTV: TextView
    private lateinit var bloodGroupTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var contactTV: TextView
    private lateinit var emailTV: TextView
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        fullNameTV = findViewById(R.id.fullName)
        genderTV = findViewById(R.id.gender)
        ageTV = findViewById(R.id.age)
        bloodGroupTV = findViewById(R.id.bloodGroup)
        addressTV = findViewById(R.id.address)
        contactTV = findViewById(R.id.contact)
        emailTV = findViewById(R.id.email)
        editButton = findViewById(R.id.btnEdit)
        val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
        val email = sharedPref.getString("email", null)

        if (email != null) {
            val db = dbController(this)
            val user = db.getUserByEmail(email)
            user?.let {
                fullNameTV.text = it["name"]
                genderTV.text = it["sex"]
                bloodGroupTV.text = it["blood_group"]
                addressTV.text = it["address"]
                contactTV.text = it["contact"]
                emailTV.text = it["email"]
                // Optional: ageTV.text = ...
            }
        }


        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Ends this activity and goes back to the previous (homepage)
        }

        editButton.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            intent.putExtra("fullName", fullNameTV.text.toString())
            intent.putExtra("gender", genderTV.text.toString())
            intent.putExtra("age", ageTV.text.toString())
            intent.putExtra("bloodGroup", bloodGroupTV.text.toString())
            intent.putExtra("address", addressTV.text.toString())
            intent.putExtra("contact", contactTV.text.toString())
            intent.putExtra("email", emailTV.text.toString())
            startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            fullNameTV.text = data.getStringExtra("fullName") ?: fullNameTV.text
            genderTV.text = data.getStringExtra("gender") ?: genderTV.text
            ageTV.text = data.getStringExtra("age") ?: ageTV.text
            bloodGroupTV.text = data.getStringExtra("bloodGroup") ?: bloodGroupTV.text
            addressTV.text = data.getStringExtra("address") ?: addressTV.text
            contactTV.text = data.getStringExtra("contact") ?: contactTV.text
            emailTV.text = data.getStringExtra("email") ?: emailTV.text
        }
    }
}
