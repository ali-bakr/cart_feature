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
import com.aliaboubakr.cart_feature.presentation.viewmodels.CartViewModel
import com.aliaboubakr.cart_feature.presentation.viewmodels.ProductsViewModel
import com.aliaboubakr.core_ui.ui.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {

    val productsViewModel: ProductsViewModel by activityViewModels()

    override fun initObservables() {

        viewLifecycleOwner.lifecycleScope.launch {
            productsViewModel.productsItemsStateFlow.collectLatest {

            }
        }
    }

}