package com.aliaboubakr.cart_feature.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aliaboubakr.cart_feature.data.local.database.entity.ProductEntity

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ProductEntity): Long

    @Update
    suspend fun update(item: ProductEntity)

    @Query("DELETE FROM products_tbl WHERE id = :itemId")
    suspend fun delete(itemId: Long)

    @Query("DELETE FROM products_tbl")
    suspend fun delete()

    @Query("SELECT * FROM products_tbl")
    suspend fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM products_tbl WHERE isBought =:isBought ORDER BY name DESC")
    suspend fun getAllItemsDes(isBought:Boolean): List<ProductEntity>
    @Query("SELECT * FROM products_tbl WHERE isBought =:isBought ORDER BY name ASC")
    suspend fun getAllItemsAsc(isBought:Boolean): List<ProductEntity>

    @Query("SELECT * FROM products_tbl WHERE isBought =:isBought AND name LIKE '%' || :query || '%' ORDER BY name DESC")
    suspend fun getSearchItemsDes(query: String,isBought:Boolean): List<ProductEntity>
    @Query("SELECT * FROM products_tbl WHERE isBought =:isBought AND name LIKE '%' || :query || '%' ORDER BY name ASC")
    suspend fun getSearchItemsAsc(query: String,isBought:Boolean): List<ProductEntity>

}