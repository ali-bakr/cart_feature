package com.aliaboubakr.cart_feature.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aliaboubakr.cart_feature.data.local.database.dao.CartDao
import com.aliaboubakr.cart_feature.data.local.database.dao.ProductsDao
import com.aliaboubakr.cart_feature.data.local.database.entity.CartEntity

@Database(entities = [CartEntity::class], version = 1, exportSchema = false)
abstract class CartDatabase :RoomDatabase(){
    abstract val cartDao: CartDao
    abstract val productsDao:ProductsDao
}