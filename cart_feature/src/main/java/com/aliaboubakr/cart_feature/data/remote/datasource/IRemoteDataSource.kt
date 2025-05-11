package com.aliaboubakr.cart_feature.data.remote.datasource

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.domain.model.CartItemDto

interface IRemoteDataSource {
    suspend fun getRemoteCartItemList():Resources<List<CartItemDto>>
    suspend fun getAvailableRemoteItemsList():Resources<List<CartItemDto>>
}