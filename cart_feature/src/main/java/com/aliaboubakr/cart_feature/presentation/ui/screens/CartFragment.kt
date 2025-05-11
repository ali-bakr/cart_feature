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

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    val cartViewModel:CartViewModel by activityViewModels()

    override fun initObservables() {

    }

}