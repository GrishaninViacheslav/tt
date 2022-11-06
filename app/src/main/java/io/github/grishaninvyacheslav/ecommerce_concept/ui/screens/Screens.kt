package io.github.grishaninvyacheslav.ecommerce_concept.ui.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.github.grishaninvyacheslav.ecommerce_concept.ui.fragments.cart.CartFragment
import io.github.grishaninvyacheslav.ecommerce_concept.ui.fragments.explorer.ExplorerFragment
import io.github.grishaninvyacheslav.ecommerce_concept.ui.fragments.product_details.ProductDetailsFragment

class Screens: IScreens {
    override fun explorer()  = FragmentScreen { ExplorerFragment.newInstance() }
    override fun productDetails()  = FragmentScreen { ProductDetailsFragment.newInstance() }
    override fun cart()  = FragmentScreen { CartFragment.newInstance() }
}