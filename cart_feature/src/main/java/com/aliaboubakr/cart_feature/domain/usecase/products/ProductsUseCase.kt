package com.aliaboubakr.cart_feature.domain.usecase.products

import javax.inject.Inject

data class ProductsUseCase @Inject constructor(
    val addProductToCartUseCase: AddProductToCartUseCase,
    val getProductsUseCase: GetProductsUseCase
)
