package com.aliaboubakr.cart_feature.domain.usecase

import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import javax.inject.Inject

class DeleteCartItemUseCase @Inject constructor(private  val cartRepository:CartRepository){
  suspend operator fun invoke(itemId:Long)=cartRepository.deleteCartItem(itemId)
}
