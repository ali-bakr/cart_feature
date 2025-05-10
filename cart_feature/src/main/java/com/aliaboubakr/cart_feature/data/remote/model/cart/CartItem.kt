package com.aliaboubakr.cart_feature.data.remote.model.cart

data class CartItem(
    val id: Long = 0,
    val name: String,
    val quantity: Int,
    val note: String?,
    val isBought: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
