package com.aliaboubakr.cart_feature.domain.usecase

import com.aliaboubakr.cart_feature.domain.model.CartItemDto
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import javax.inject.Inject

class AddCartItemUseCase @Inject constructor(private  val cartRepository: CartRepository){
    suspend operator fun invoke(itemId: CartItemDto)=cartRepository.addCartItem(itemId)
}
