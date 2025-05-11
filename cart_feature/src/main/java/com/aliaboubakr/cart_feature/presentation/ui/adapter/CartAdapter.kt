package com.aliaboubakr.cart_feature.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aliaboubakr.cart_feature.databinding.ItemCartBinding
import com.aliaboubakr.cart_feature.domain.model.CartItemDto
import com.aliaboubakr.cart_feature.presentation.ui.viewholder.CartViewHolder
import com.aliaboubakr.core_ui.ui.base.BaseAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CartAdapter @Inject constructor(@ApplicationContext private val context:Context) :BaseAdapter<CartItemDto,CartViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemCartBinding =ItemCartBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(itemCartBinding,context)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(items[position],onItemClickListener)
    }
}