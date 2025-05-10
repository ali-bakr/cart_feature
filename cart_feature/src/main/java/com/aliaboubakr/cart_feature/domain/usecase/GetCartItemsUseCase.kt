package com.aliaboubakr.cart_feature.domain.usecase

import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import javax.inject.Inject

class GetCartItemsUseCase @Inject constructor(private  val cartRepository: CartRepository){
    suspend operator fun invoke(query:String?=null)=cartRepository.getCartItemsByName(query)
    suspend operator fun invoke(query:String?=null,showBought:Boolean)=cartRepository.getCartItemsByName(query,showBought)
    suspend operator fun invoke(query:String?=null,showBought:Boolean,sortCriteria: SortCriteria)=cartRepository.getCartItemsByName(query,showBought,sortCriteria)
}
