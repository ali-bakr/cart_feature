package com.aliaboubakr.navigationrouter

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.createGraph
public sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    data object ProductsScreen : NoArgumentsDestination(PRODUCTS_ROUTE)
    data object CartScreen : NoArgumentsDestination(CART_ROUTE)



    companion object {
        private const val CART_ROUTE = "cart"
        private const val PRODUCTS_ROUTE = "products"
    }
}







fun Context.getStringResource(resourceId: Int): String =
    resources.getString(resourceId)

fun NavController.navigateTo(
    destination: String,
    clearBackStack: Boolean = false,
) {
    navigate(destination) {
        if (clearBackStack) {
            popUpTo(0)
        }

    }

}