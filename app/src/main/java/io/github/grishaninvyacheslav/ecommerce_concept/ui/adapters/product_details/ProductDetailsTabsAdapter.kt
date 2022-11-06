package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.product_details

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.grishaninvyacheslav.ecommerce_concept.ui.fragments.product_details.ProductDetailTabFragment

class ProductDetailsTabsAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int) = ProductDetailTabFragment.newInstance()
}