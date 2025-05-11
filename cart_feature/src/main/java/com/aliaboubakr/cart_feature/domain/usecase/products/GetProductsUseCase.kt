package com.aliaboubakr.cart_feature.domain.usecase.products

import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import com.aliaboubakr.cart_feature.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private  val productsRepository: ProductsRepository){
    suspend operator fun invoke(query:String?=null)=productsRepository.getProductsItemsByName(query)
    suspend operator fun invoke(query:String?=null,showBought:Boolean)=productsRepository.getProductsItemsByName(query,showBought)
    suspend operator fun invoke(query:String?=null,showBought:Boolean,sortCriteria: SortCriteria)=productsRepository.getProductsItemsByName(query,showBought,sortCriteria)
}
