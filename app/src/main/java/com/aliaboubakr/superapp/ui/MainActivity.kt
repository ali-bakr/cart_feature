package com.aliaboubakr.superapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.fragment
import com.aliaboubakr.cart_feature.presentation.ui.screens.CartFragment
import com.aliaboubakr.cart_feature.presentation.ui.screens.ProductsFragment
import com.aliaboubakr.navigationrouter.getStringResource
import com.aliaboubakr.superapp.R
import com.aliaboubakr.superapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment_super)
        navController.graph = navController.setupGraph(this)
        navController.addOnDestinationChangedListener { _, destination, _ ->
//            val actionBar = checkNotNull(supportActionBar) {
//                "Activity ${this@MainActivity} does not have an ActionBar set via setSupportActionBar()"
//            }
//            actionBar.title = destination.label

        }
    }

fun NavController.setupGraph(context: Context) = createGraph(
    startDestination = com.aliaboubakr.navigationrouter.Destination.ProductsScreen.fullRoute
) {
    fragment<CartFragment>(com.aliaboubakr.navigationrouter.Destination.CartScreen.fullRoute) {
        label = context.getStringResource(R.string.title_cart)
    }
    fragment<ProductsFragment>(com.aliaboubakr.navigationrouter.Destination.ProductsScreen.fullRoute) {
        label = context.getStringResource(R.string.title_products)
    }
}
}
