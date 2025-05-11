package com.aliaboubakr.cart_feature.domain.usecase.products

import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.domain.repository.ProductsRepository
import javax.inject.Inject

 class AddProductToCartUseCase @Inject constructor(private val productsRepository: ProductsRepository){
     suspend operator fun invoke(itemId: ProductItemDto)=productsRepository.addCartItem(itemId)
 }
