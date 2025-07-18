package com.example.bloodbank2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import dbContoller.dbController

class Login : AppCompatActivity() {

    private lateinit var db: dbController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = dbController(this)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.button_register)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val isValidUser = db.validateUser(email, password)
            if (isValidUser) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
                sharedPref.edit().putString("email", email).apply()
                startActivity(Intent(this, HomePage::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }
    }
}
