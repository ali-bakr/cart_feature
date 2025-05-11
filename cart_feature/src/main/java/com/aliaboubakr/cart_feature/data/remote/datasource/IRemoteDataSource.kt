package com.aliaboubakr.cart_feature.data.remote.datasource

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto

interface IRemoteDataSource {
    suspend fun getRemoteCartItemList():Resources<List<ProductItemDto>>
    suspend fun getAvailableRemoteItemsList():Resources<List<ProductItemDto>>
}