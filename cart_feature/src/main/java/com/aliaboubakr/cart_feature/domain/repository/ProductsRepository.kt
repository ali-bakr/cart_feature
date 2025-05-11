package com.aliaboubakr.cart_feature.domain.repository

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
//    suspend fun getAllCartItems(
//        showBought: Boolean?=true,
//        sortAsc: SortCriteria = SortCriteria.SORT_ASS
//    ): Flow<Resources<List<CartItemDto>>>
    suspend fun getProductsItemsByName(
    query: String?,
    showBought: Boolean=true,
    sortAsc: SortCriteria = SortCriteria.SORT_ASC,
    isForceRefresh :Boolean=false
    ): Flow<Resources<List<ProductItemDto>>>

    suspend fun addCartItem(item: ProductItemDto)

}