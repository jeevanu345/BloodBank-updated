package com.example.bloodbank2


import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.bloodbank2.R
import dbContoller.dbController


class EditProfile : AppCompatActivity() {

    private lateinit var editFullName: EditText
    private lateinit var editGender: EditText
    private lateinit var editAge: EditText
    private lateinit var editBloodGroup: EditText
    private lateinit var editAddress: EditText
    private lateinit var editContact: EditText
    private lateinit var editEmail: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile) // your XML filename

        // Find views
        editFullName = findViewById(R.id.editFullName)
        editGender = findViewById(R.id.editGender)
        editAge = findViewById(R.id.editAge)
        editBloodGroup = findViewById(R.id.editBloodGroup)
        editAddress = findViewById(R.id.editAddress)
        editContact = findViewById(R.id.editContact)
        editEmail = findViewById(R.id.editEmail)
        btnSave = findViewById(R.id.btnSave)

        // Load existing data from intent extras
        editFullName.setText(intent.getStringExtra("fullName"))
        editGender.setText(intent.getStringExtra("gender"))
        editAge.setText(intent.getStringExtra("age"))
        editBloodGroup.setText(intent.getStringExtra("bloodGroup"))
        editAddress.setText(intent.getStringExtra("address"))
        editContact.setText(intent.getStringExtra("contact"))
        editEmail.setText(intent.getStringExtra("email"))

        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }


        btnSave.setOnClickListener {
            // Prepare intent to send back updated data
            val db = dbController(this)
            val result = db.updateUserByEmail(
                editEmail.text.toString(),
                editFullName.text.toString(),
                editGender.text.toString(),
                editBloodGroup.text.toString(),
                editContact.text.toString(),
                editAddress.text.toString()
            )
            val resultIntent = Intent().apply {
                putExtra("fullName", editFullName.text.toString())
                putExtra("gender", editGender.text.toString())
                putExtra("age", editAge.text.toString())
                putExtra("bloodGroup", editBloodGroup.text.toString())
                putExtra("address", editAddress.text.toString())
                putExtra("contact", editContact.text.toString())
                putExtra("email", editEmail.text.toString())
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()  // Close this activity and return
        }

    }
}
