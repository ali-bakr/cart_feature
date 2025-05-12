package com.aliaboubakr.cart_feature.data.remote.datasource

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.helper.MockHelper
import com.aliaboubakr.cart_feature.data.remote.ShoppingAPi
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor (private val shoppingAPi: ShoppingAPi) : IRemoteDataSource {
    override suspend fun getRemoteCartItemList(): Resources<List<ProductItemDto>> {
        return try {
            val data = featchRemoteCartItemsMocked()
            if (data.isNotEmpty()){
                Resources.Success(data)
            }else{
                Resources.Error("ERROR Empty Data")
            }
        }catch (e :Exception){
            Resources.Error("ERROR ${e.localizedMessage}")
        }
    }
    override suspend fun getAvailableRemoteItemsList():Resources<List<ProductItemDto>> {
        return try {
            val data = featchAllRemoteItemsMocked()
            if (data.isNotEmpty()){
                Resources.Success(data)
            }else{
                Resources.Error("ERROR Empty Data")
            }
        }catch (e :Exception){
            Resources.Error("ERROR ${e.localizedMessage}")
        }
    }
    private suspend fun featchRemoteCartItemsMocked(): List<ProductItemDto> {
        return MockHelper.generateMockCartItems()
    }
    private suspend fun featchAllRemoteItemsMocked(): List<ProductItemDto> {
        return MockHelper.generateMockProductItems()
    }

}
