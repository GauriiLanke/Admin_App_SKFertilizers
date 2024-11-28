package com.example.adminpanel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrdersAdapter(private val orders: MutableList<Order>) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderIdTextView: TextView = view.findViewById(R.id.orderIdTextView)
        val customerDetailsTextView: TextView = view.findViewById(R.id.customerDetailsTextView)
        val totalPriceTextView: TextView = view.findViewById(R.id.totalPriceTextView)
        val itemsTextView: TextView = view.findViewById(R.id.itemsTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.orderIdTextView.text = "Order ID: ${order.orderId}"
        holder.customerDetailsTextView.text = "Customer Name: ${order.customerName}\nEmail: ${order.customerEmail}\nPhone: ${order.customerPhone}"
        holder.itemsTextView.text = "Products:\n${order.items.joinToString("\n") { "${it["name"]} - Quantity: ${it["quantity"]}" }}"
        holder.totalPriceTextView.text = "Total Bill: ₹${order.totalPrice}"
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    fun updateOrders(newOrders: List<Order>) {
        orders.clear()
        orders.addAll(newOrders)
        notifyDataSetChanged()
    }
}
