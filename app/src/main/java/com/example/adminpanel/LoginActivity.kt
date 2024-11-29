package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginn = findViewById<AppCompatButton>(R.id.btnSignIn)
        val signInEmail = findViewById<EditText>(R.id.etSinInEmail)
        val signInPass = findViewById<EditText>(R.id.etSinInPassword)

        loginn.setOnClickListener {
            val email = signInEmail.text.toString()
            val password = signInPass.text.toString()

            if (email == "shrikrushnafertilizers3607@gmail.com" && password == "cvbn@8274") {
                // Navigate to OrdersActivity and clear the back stack
                val intent = Intent(this, OrdersActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Disable back press for LoginActivity
        finishAffinity() // Close the app if the back button is pressed
    }
}
