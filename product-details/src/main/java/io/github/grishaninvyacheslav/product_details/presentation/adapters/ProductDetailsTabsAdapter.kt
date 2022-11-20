package io.github.grishaninvyacheslav.product_details.presentation.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.grishaninvyacheslav.product_details.presentation.fragments.ProductDetailTabFragment

class ProductDetailsTabsAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int) = ProductDetailTabFragment.newInstance()
}