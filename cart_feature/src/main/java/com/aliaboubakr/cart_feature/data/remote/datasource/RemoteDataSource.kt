package com.aliaboubakr.cart_feature.data.remote.datasource

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.helper.MockHelper
import com.aliaboubakr.cart_feature.data.remote.CartAPi
import com.aliaboubakr.cart_feature.domain.model.CartItemDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor (private val cartAPi: CartAPi) : IRemoteDataSource {
    override suspend fun getRemoteCartItemList(): Resources<List<CartItemDto>> {
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
    private suspend fun featchRemoteCartItemsMocked(): List<CartItemDto> {
        return MockHelper.generateMockCartItems()
    }

}
