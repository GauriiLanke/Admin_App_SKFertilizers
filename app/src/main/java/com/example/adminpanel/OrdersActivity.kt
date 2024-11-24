package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        val viewOrdersButton = findViewById<Button>(R.id.viewOrdersButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        viewOrdersButton.setOnClickListener {
            // Navigate to the orders page
            val intent = Intent(this, ViewOrdersActivity::class.java)
            startActivity(intent)
        }

        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

