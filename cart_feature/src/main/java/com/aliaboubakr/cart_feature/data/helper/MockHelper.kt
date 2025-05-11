package com.aliaboubakr.cart_feature.data.helper

import com.aliaboubakr.cart_feature.domain.model.CartItemDto

object MockHelper {
    fun generateMockCartItems(): List<CartItemDto> {
        return listOf(
            CartItemDto(1, "Milk", 2, "Low fat", false, 1715300000000),
            CartItemDto(2, "Bread", 1, "Whole grain", true, 1715301000000),
            CartItemDto(3, "Eggs", 12, null, false, 1715302000000),
            CartItemDto(4, "Bananas", 6, "Ripe ones", false, 1715303000000),
            CartItemDto(5, "Chicken", 1, "Boneless", true, 1715304000000),
            CartItemDto(6, "Apples", 4, "Green apples", false, 1715305000000),
            CartItemDto(7, "Rice", 1, null, true, 1715306000000),
        )
    }
    fun generateMockProductItems():List<CartItemDto> {
        return listOf(
            CartItemDto(1, "Milk", 2, "Low fat", false, 1715300000000),
            CartItemDto(2, "Bread", 1, "Whole grain", true, 1715301000000),
            CartItemDto(3, "Eggs", 12, null, false, 1715302000000),
            CartItemDto(4, "Bananas", 6, "Ripe ones", false, 1715303000000),
            CartItemDto(5, "Chicken", 1, "Boneless", true, 1715304000000),
            CartItemDto(6, "Apples", 4, "Green apples", false, 1715305000000),
            CartItemDto(7, "Rice", 1, null, true, 1715306000000),
            CartItemDto(8, "Pasta", 2, null, false, 1715307000000),
            CartItemDto(9, "Cheese", 1, "Mozzarella", false, 1715308000000),
            CartItemDto(10, "Tomatoes", 5, null, true, 1715309000000),
            CartItemDto(11, "Cereal", 1, "No sugar", false, 1715310000000),
            CartItemDto(12, "Yogurt", 3, null, false, 1715311000000),
            CartItemDto(13, "Peanut Butter", 1, "Crunchy", true, 1715312000000),
            CartItemDto(14, "Coffee", 1, "Arabica beans", false, 1715313000000),
            CartItemDto(15, "Orange Juice", 2, null, true, 1715314000000)
        )
    }
}