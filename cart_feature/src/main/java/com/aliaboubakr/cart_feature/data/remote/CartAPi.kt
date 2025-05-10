package com.aliaboubakr.cart_feature.data.remote

import com.aliaboubakr.cart_feature.data.remote.model.cart.CartItems
import retrofit2.http.GET
import retrofit2.http.Query

interface CartAPi {
    @GET("search")
    suspend fun getCartItems(
        @Query("q") q:String
    ): CartItems
}