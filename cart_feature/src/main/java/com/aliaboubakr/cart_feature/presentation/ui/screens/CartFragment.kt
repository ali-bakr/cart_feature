package com.aliaboubakr.cart_feature.presentation.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.aliaboubakr.cart_feature.R
import com.aliaboubakr.cart_feature.databinding.FragmentCartBinding
import com.aliaboubakr.cart_feature.presentation.viewmodels.CartViewModel
import com.aliaboubakr.core_ui.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.presentation.ui.adapter.CartAdapter
import com.aliaboubakr.core_ui.data.enum.Action
import com.aliaboubakr.core_ui.domain.model.OnItemClickedListener
import com.aliaboubakr.core_ui.ui.utils.DialogUtils
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate),OnItemClickedListener<ProductItemDto> {

    val cartViewModel:CartViewModel by activityViewModels()
    @Inject
    lateinit var cartAdapter: CartAdapter
    override fun initObservables() {
        initViews()
            viewLifecycleOwner.lifecycleScope.launch {
                cartViewModel.cartItemsStateFlow.collectLatest {
                    when(it){
                        is Resources.Success->{
                            it.data?.let {
                                cartAdapter.submitList(it)
                            }

                        }
                        else -> {}
                    }

                }
            }

        viewLifecycleOwner.lifecycleScope.launch {
            cartViewModel.cartAlertDialogStateFlow.collectLatest {
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

            viewLifecycleOwner.lifecycleScope.launch {
                cartViewModel.showProgressStateFlow .collect {
                    handelProgress(it)
                }
            }

            viewLifecycleOwner.lifecycleScope.launch {
                cartViewModel.showEmptyLayoutStateFlow .collect {

                }
            }
        }
    private fun handelProgress(it: Boolean) {
        binding.progress.visibility=if (it) View.VISIBLE else View.GONE
    }
    private fun initViews() {
        with(binding){
            cartRv.adapter=cartAdapter
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