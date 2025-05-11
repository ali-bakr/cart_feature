package com.aliaboubakr.cart_feature.data.mapper

import com.aliaboubakr.cart_feature.data.local.database.entity.CartEntity
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto

object CartMapper {
    fun CartEntity.toItemDto(): ProductItemDto {
        return ProductItemDto(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }

    fun ProductItemDto.toEntity(): CartEntity {
        return CartEntity(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }
    fun List<CartEntity>.toItemDtoList(): List<ProductItemDto> {
        return map { it.toItemDto() }
    }

    fun List<ProductItemDto>.toEntityList(): List<CartEntity> {
        return map { it.toEntity() }
    }
}