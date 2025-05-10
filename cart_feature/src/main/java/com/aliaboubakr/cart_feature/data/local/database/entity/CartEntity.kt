package com.aliaboubakr.cart_feature.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aliaboubakr.cart_feature.data.constants.DatabaseConstants.CART_TABLE

@Entity(tableName = CART_TABLE)
data class CartEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val quantity: Int,
    val note: String?,
    val isBought: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
    )