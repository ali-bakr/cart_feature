package com.aliaboubakr.core_ui.domain.model

import com.aliaboubakr.core_ui.data.enum.Action

interface OnItemClickedListener <T>{
    fun onItemClick(item:T,action: Action = Action.CLICK)
}