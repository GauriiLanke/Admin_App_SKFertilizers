package com.example.adminpanel

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ViewOrdersActivity : AppCompatActivity() {

    private lateinit var ordersRecyclerView: RecyclerView
    private lateinit var ordersAdapter: OrdersAdapter
    private lateinit var database: FirebaseDatabase
    private lateinit var ordersRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_orders)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        ordersRecyclerView = findViewById(R.id.ordersRecyclerView)
        ordersRecyclerView.layoutManager = LinearLayoutManager(this)

        ordersAdapter = OrdersAdapter(mutableListOf())
        ordersRecyclerView.adapter = ordersAdapter

        database = FirebaseDatabase.getInstance()
        ordersRef = database.getReference("orders")

        fetchOrders()
    }

    private fun fetchOrders() {
        ordersRef.orderByChild("timestamp").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val ordersList = mutableListOf<Order>()
                for (orderSnapshot in snapshot.children) {
                    val order = orderSnapshot.getValue(Order::class.java)
                    if (order != null) {
                        ordersList.add(order)
                    }
                }
                ordersAdapter.updateOrders(ordersList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ViewOrdersActivity", "Failed to fetch orders", error.toException())
                Toast.makeText(this@ViewOrdersActivity, "Failed to load orders.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
