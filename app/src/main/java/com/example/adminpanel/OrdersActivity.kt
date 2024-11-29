package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

            // Navigate back to LoginActivity and clear the back stack
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Disable back press for OrdersActivity to prevent navigation to LoginActivity
        moveTaskToBack(true) // Send the app to the background instead of navigating back
    }
}
