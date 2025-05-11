package com.aliaboubakr.cart_feature.data.mapper

import com.aliaboubakr.cart_feature.data.local.database.entity.CartEntity
import com.aliaboubakr.cart_feature.data.local.database.entity.ProductEntity
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto

object ProductsMapper {
    fun ProductEntity.toItemDto(): ProductItemDto {
        return ProductItemDto(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }

    fun ProductItemDto.toEntity(): ProductEntity {
        return ProductEntity(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }

    fun ProductItemDto.toCartEntity(): CartEntity {
        return CartEntity(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }
    fun ProductItemDto.toProductEntity(): ProductEntity {
        return ProductEntity(
            id = id,
            name = name,
            quantity = quantity,
            note = note,
            isBought = isBought,
            timestamp = timestamp
        )
    }
    fun List<ProductEntity>.toItemDtoList(): List<ProductItemDto> {
        return map { it.toItemDto() }
    }

    fun List<ProductItemDto>.toEntityList(): List<ProductEntity> {
        return map { it.toEntity() }
    }
}