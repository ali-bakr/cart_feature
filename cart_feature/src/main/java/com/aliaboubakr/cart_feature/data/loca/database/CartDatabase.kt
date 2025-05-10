package com.aliaboubakr.cart_feature.data.loca.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aliaboubakr.cart_feature.data.loca.database.dao.CartDao
import com.aliaboubakr.cart_feature.data.loca.database.entity.CartEntity

@Database(entities = [CartEntity::class], version = 1, exportSchema = false)
abstract class CartDatabase :RoomDatabase(){
    abstract val cartDao: CartDao
}