package com.aliaboubakr.cart_feature.data.remote

import com.aliaboubakr.cart_feature.data.remote.model.cart.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingAPi {
    @GET("products/grocery?")
    suspend fun getAllGroceryItems(
        @Query("q") q:String
    ): ProductsResponse

    @GET("{user_id}/cart?")
    suspend fun getCartItems(
        @Query("q") q:String
    ): ProductsResponse
}