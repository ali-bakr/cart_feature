package com.aliaboubakr.cart_feature.domain.model

data class CartItemDto(
    val id: Long = 0,
    val name: String,
    val quantity: Int,
    val note: String?,
    val isBought: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)