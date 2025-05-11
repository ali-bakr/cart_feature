package com.aliaboubakr.cart_feature.domain.usecase

import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import javax.inject.Inject

class AddCartItemUseCase @Inject constructor(private  val cartRepository: CartRepository){
    suspend operator fun invoke(itemId: ProductItemDto)=cartRepository.addCartItem(itemId)
}
