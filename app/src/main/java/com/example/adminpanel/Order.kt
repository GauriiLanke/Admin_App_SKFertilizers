package com.example.adminpanel

data class Order(
    val orderId: String = "",
    val customerName: String = "",
    val customerEmail: String = "",
    val customerPhone: String = "",
    val items: List<Map<String, Any>> = emptyList(),
    val totalPrice: Double = 0.0,
    val timestamp: Long = 0L
)

