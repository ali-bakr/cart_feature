package com.aliaboubakr.core_ui.ui.base

import androidx.recyclerview.widget.RecyclerView
import com.aliaboubakr.core_ui.domain.model.OnItemClickedListener

abstract class BaseAdapter <T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {
    protected val items = mutableListOf<T>()
    protected var onItemClickedListener:OnItemClickedListener<T>?= null
    fun submitList(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    protected fun getItem(position: Int): T = items[position]

    fun setOnItemClickListener(onItemClickedListener: OnItemClickedListener<T>){
        this.onItemClickedListener=onItemClickedListener
    }
}