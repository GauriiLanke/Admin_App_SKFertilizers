package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginn=findViewById<AppCompatButton>(R.id.Loginbutton)
        val signInEmail=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val signInPass=findViewById<EditText>(R.id.editTextTextPassword)

        loginn.setOnClickListener{
            val email=signInEmail.text.toString()
            val password=signInPass.text.toString()
            if(email=="shrikrushnafertilizers3607@gmail.com" && password=="cvbn@8274"){
                val intent = Intent(this, OrdersActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Wrong credentials", Toast.LENGTH_SHORT).show()
            }

        }

    }
}