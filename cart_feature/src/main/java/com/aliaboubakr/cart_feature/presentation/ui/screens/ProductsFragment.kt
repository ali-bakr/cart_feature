package com.aliaboubakr.cart_feature.presentation.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.aliaboubakr.cart_feature.databinding.FragmentCartBinding
import com.aliaboubakr.cart_feature.databinding.FragmentProductsBinding
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.presentation.ui.adapter.ProductsAdapter
import com.aliaboubakr.cart_feature.presentation.viewmodels.CartViewModel
import com.aliaboubakr.cart_feature.presentation.viewmodels.ProductsViewModel
import com.aliaboubakr.core_ui.data.enum.Action
import com.aliaboubakr.core_ui.domain.model.OnItemClickedListener
import com.aliaboubakr.core_ui.ui.base.BaseFragment
import com.aliaboubakr.core_ui.ui.utils.DialogUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate),OnItemClickedListener<ProductItemDto> {

    val productsViewModel: ProductsViewModel by activityViewModels()

    @Inject
    lateinit var productAdapter :ProductsAdapter
    override fun initObservables() {

        viewLifecycleOwner.lifecycleScope.launch {
            productsViewModel.productsItemsStateFlow.collectLatest {


            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            productsViewModel.showProgressStateFlow .collect {

            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            productsViewModel.showEmptyLayoutStateFlow .collect {

            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            productsViewModel.cartAlertDialogStateFlow.collect{
                DialogUtils.showGeneralMessageDialog(
                    context = requireContext(),
                    message = "Message :$it .",
                    onPositive = {
                    },
                    onNegative = {
                    }
                )
            }
        }
    }
    private fun initViews() {
        with(binding){
            productsRv.adapter=productAdapter
        }
    }
    override fun onItemClick(item: ProductItemDto, action: Action) {

        when(action){
            Action.ADD_TO_CART->{

            }
            else ->{}
        }


    }

}