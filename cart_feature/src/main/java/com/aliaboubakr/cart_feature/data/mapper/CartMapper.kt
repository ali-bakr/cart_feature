package com.aliaboubakr.cart_feature.data.mapper

import com.aliaboubakr.cart_feature.data.local.database.entity.CartEntity
import com.aliaboubakr.cart_feature.domain.model.CartItemDto

object CartMapper {
    fun CartEntity.toItemDto(): CartItemDto {
        return CartItemDto(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }

    fun CartItemDto.toEntity(): CartEntity {
        return CartEntity(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }
    fun List<CartEntity>.toItemDtoList(): List<CartItemDto> {
        return map { it.toItemDto() }
    }

    fun List<CartItemDto>.toEntityList(): List<CartEntity> {
        return map { it.toEntity() }
    }
}