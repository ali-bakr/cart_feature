package com.aliaboubakr.cart_feature.data.remote.model.cart

import com.google.gson.annotations.SerializedName

data class CartItems(
    @SerializedName("cartItems")
    var cartItems: ArrayList<CartItem>,
)
