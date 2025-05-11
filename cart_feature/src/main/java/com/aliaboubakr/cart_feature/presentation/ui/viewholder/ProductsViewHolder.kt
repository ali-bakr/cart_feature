package com.aliaboubakr.cart_feature.presentation.ui.viewholder

import android.content.Context
import com.aliaboubakr.cart_feature.databinding.ItemCartBinding
import com.aliaboubakr.cart_feature.databinding.ItemProductsBinding
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.core_ui.data.enum.Action
import com.aliaboubakr.core_ui.domain.model.OnItemClickedListener
import com.aliaboubakr.core_ui.ui.base.BaseViewHolder

class ProductsViewHolder(private val binding: ItemProductsBinding, private val context: Context) :BaseViewHolder<ProductItemDto>(binding.root){
    override fun bind(item: ProductItemDto, listener: OnItemClickedListener<ProductItemDto>?) {
        binding.productNameTv.text=item.name
        binding.productNoteTv.text=item.note?:""
        binding.addToCartBtn.setOnClickListener{
            listener?.onItemClick(item,Action.ADD_TO_CART)
        }
    }

}