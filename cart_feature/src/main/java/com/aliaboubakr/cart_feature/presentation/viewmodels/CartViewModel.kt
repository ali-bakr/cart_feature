package com.aliaboubakr.cart_feature.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.domain.model.CartItemDto
import com.aliaboubakr.cart_feature.domain.usecase.CartUseCase
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
class CartViewModel  @Inject constructor(
    private val cartUseCase: CartUseCase,
) : ViewModel() {

    private val _cartItemsStateFlow = MutableStateFlow<Resources<List<CartItemDto>>>(Resources.Loading())
    val cartItemsStateFlow: StateFlow<Resources<List<CartItemDto>>> = _cartItemsStateFlow.asStateFlow()

    private val _showProgressStateFlow = MutableStateFlow<Boolean>(false)
    val showProgressStateFlow: StateFlow<Boolean> = _showProgressStateFlow.asStateFlow()

    private val _showEmptyLayoutStateFlow = MutableStateFlow<Boolean>(false)
    val showEmptyLayoutStateFlow: StateFlow<Boolean> = _showEmptyLayoutStateFlow.asStateFlow()


    suspend fun loadCartItems(query: String? = null, showBought: Boolean = true, sortCriteria: SortCriteria = SortCriteria.SORT_ASC) {
        viewModelScope.launch {
           cartUseCase.getCartItemsUseCase.invoke(query,showBought, sortCriteria).onStart {
               _showProgressStateFlow.emit(true)
           }.catch {
               _showProgressStateFlow.emit(false)
           }.collectLatest {
               _showProgressStateFlow.emit(false)
               _showProgressStateFlow.emit(it.data.isNullOrEmpty())
               _cartItemsStateFlow.emit(it)
           }
        }
    }

    fun updateItem(item: CartItemDto) {
        viewModelScope.launch {
            val updated = item.copy(isBought = !item.isBought)
            cartUseCase.updateCartItemUseCase.invoke(updated)
            loadCartItems() // Refresh after update
        }
    }
    fun deleteItem(item: CartItemDto) {
        viewModelScope.launch {
            cartUseCase.deleteCartItem.invoke(item.id)
            loadCartItems() // Refresh after update
        }
    }
    fun deleteAllItems() {
        viewModelScope.launch {
            cartUseCase.deleteCartItem.invoke()
            loadCartItems() // Refresh after update
        }
    }
}