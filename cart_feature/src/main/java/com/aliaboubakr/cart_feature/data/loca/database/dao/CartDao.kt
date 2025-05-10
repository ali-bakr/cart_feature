package com.aliaboubakr.cart_feature.data.loca.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aliaboubakr.cart_feature.data.loca.database.entity.CartEntity

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CartEntity): Long

    @Update
    suspend fun update(item: CartEntity)

    @Query("DELETE FROM cart_tbl WHERE id = :itemId")
    suspend fun deleteById(itemId: Long)

    @Query("SELECT * FROM cart_tbl")
    suspend fun getAll(): List<CartEntity>
}