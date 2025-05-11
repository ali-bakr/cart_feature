package com.aliaboubakr.cart_feature.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aliaboubakr.cart_feature.databinding.ItemCartBinding
import com.aliaboubakr.cart_feature.databinding.ItemProductsBinding
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.presentation.ui.viewholder.CartViewHolder
import com.aliaboubakr.cart_feature.presentation.ui.viewholder.ProductsViewHolder
import com.aliaboubakr.core_ui.ui.base.BaseAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ProductsAdapter @Inject constructor(@ApplicationContext private val context:Context) :BaseAdapter<ProductItemDto, ProductsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemProductsBinding =ItemProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductsViewHolder(itemProductsBinding,context)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(items[position],onItemClickedListener)
    }
}