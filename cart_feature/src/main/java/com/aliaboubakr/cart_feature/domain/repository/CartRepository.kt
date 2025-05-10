package com.aliaboubakr.cart_feature.domain.repository

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.domain.model.CartItemDto
import kotlinx.coroutines.flow.Flow

interface CartRepository {
//    suspend fun getAllCartItems(
//        showBought: Boolean?=true,
//        sortAsc: SortCriteria = SortCriteria.SORT_ASS
//    ): Flow<Resources<List<CartItemDto>>>
    suspend fun getCartItemsByName(
    query: String?,
    showBought: Boolean=true,
    sortAsc: SortCriteria = SortCriteria.SORT_ASC,
    isForceRefresh :Boolean=false
    ): Flow<Resources<List<CartItemDto>>>

    suspend fun addCartItem(item: CartItemDto)
    suspend fun updateCartItem(item: CartItemDto)
    suspend fun deleteCartItem(itemId: Long)
    suspend fun syncCart()
}