package com.aliaboubakr.core_ui.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aliaboubakr.core_ui.domain.model.OnItemClickedListener

abstract class BaseViewHolder <T>(itemView: View, listener: OnItemClickedListener<T>? = null) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, listener: OnItemClickedListener<T>?)
}


