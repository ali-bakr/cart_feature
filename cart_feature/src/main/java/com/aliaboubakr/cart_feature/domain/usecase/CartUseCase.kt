package com.aliaboubakr.cart_feature.domain.usecase

import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import javax.inject.Inject

data class CartUseCase @Inject constructor(
    val deleteCartItem: DeleteCartItemUseCase,
    val addCartItemUseCase: AddCartItemUseCase,
    val updateCartItemUseCase: UpdateCartItemUseCase,
    val getCartItemsUseCase: GetCartItemsUseCase)
