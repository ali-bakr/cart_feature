package com.aliaboubakr.cart_feature.presentation.ui.viewholder

import android.content.Context
import com.aliaboubakr.cart_feature.databinding.ItemCartBinding
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.core_ui.data.enum.Action
import com.aliaboubakr.core_ui.domain.model.OnItemClickedListener
import com.aliaboubakr.core_ui.ui.base.BaseViewHolder

class CartViewHolder(private val binding: ItemCartBinding,private val context: Context) :BaseViewHolder<ProductItemDto>(binding.root){
    override fun bind(item: ProductItemDto, listener: OnItemClickedListener<ProductItemDto>?) {
        binding.itemName.text=item.name
        binding.itemNote.text=item.note?:""
        binding.processToByBtn.setOnClickListener{
            listener?.onItemClick(item,Action.BUY)
        }
        binding.deleteBtn.setOnClickListener{
            listener?.onItemClick(item,Action.DELETE)
        }
    }

}