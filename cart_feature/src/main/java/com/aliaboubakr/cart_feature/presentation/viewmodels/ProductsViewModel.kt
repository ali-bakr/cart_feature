package com.aliaboubakr.cart_feature.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.domain.usecase.products.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel  @Inject constructor(
    private val productsUseCase: ProductsUseCase,
) : ViewModel() {

    private val _productsItemsStateFlow = MutableStateFlow<Resources<List<ProductItemDto>>>(Resources.Loading())
    val productsItemsStateFlow: StateFlow<Resources<List<ProductItemDto>>> = _productsItemsStateFlow.asStateFlow()

    private val _showProgressStateFlow = MutableStateFlow<Boolean>(false)
    val showProgressStateFlow: StateFlow<Boolean> = _showProgressStateFlow.asStateFlow()

    private val _showEmptyLayoutStateFlow = MutableStateFlow<Boolean>(false)
    val showEmptyLayoutStateFlow: StateFlow<Boolean> = _showEmptyLayoutStateFlow.asStateFlow()

    private val _cartAlertDialogStateFlow = MutableStateFlow<String>("")
    val cartAlertDialogStateFlow: StateFlow<String> = _cartAlertDialogStateFlow.asStateFlow()

    init {
        loadProductsItems(showBought = false, sortCriteria = SortCriteria.SORT_ASC)
    }

     fun loadProductsItems(query: String? = null, showBought: Boolean = false, sortCriteria: SortCriteria = SortCriteria.SORT_ASC) {
        viewModelScope.launch {
            productsUseCase.getProductsUseCase.invoke(query,showBought, sortCriteria).onStart {
               _showProgressStateFlow.emit(true)
           }.catch {
               _showProgressStateFlow.emit(false)
                _cartAlertDialogStateFlow.emit("Error ${it.localizedMessage}")
           }.collectLatest {
               _showProgressStateFlow.emit(false)
               _showProgressStateFlow.emit(it.data.isNullOrEmpty())
               _productsItemsStateFlow.emit(it)
           }
        }
    }

    fun addProductToCart(item: ProductItemDto) {
        viewModelScope.launch {
            val updated = item.copy(isBought = !item.isBought)
            productsUseCase.addProductToCartUseCase.invoke(updated)
            _cartAlertDialogStateFlow.emit("Item ${item.name} added to cart.")
            loadProductsItems()
        }
    }

}