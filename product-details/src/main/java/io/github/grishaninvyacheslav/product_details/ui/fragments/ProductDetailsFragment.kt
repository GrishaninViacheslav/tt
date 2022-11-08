package io.github.grishaninvyacheslav.product_details.ui.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import io.github.grishaninvyacheslav.network.data.data_entity.ProductImageEntity
import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.core_ui.ui.BaseFragment
import io.github.grishaninvyacheslav.core_ui.ui.IBottomNavigation
import io.github.grishaninvyacheslav.product_details.R
import io.github.grishaninvyacheslav.product_details.databinding.FragmentProductDetailsBinding
import io.github.grishaninvyacheslav.product_details.databinding.ViewProductDetailsTabTextBinding
import io.github.grishaninvyacheslav.product_details.ui.adapters.ProductDetailsTabsAdapter
import io.github.grishaninvyacheslav.product_details.ui.adapters.ProductImagesListAdapter
import io.github.grishaninvyacheslav.product_details.ui.view_models.ProductDetailsViewModel
import io.github.grishaninvyacheslav.product_details.ui.view_models.ProductState
import io.github.grishaninvyacheslav.product_details.utils.toProductImageEntitiesList
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs

class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as IBottomNavigation).isNavigationVisible = false
        initView()
        initTabLayout()
        initObservers()
    }

    private fun initView() = with(binding){
        back.setOnClickListener {
            router.exit()
        }
        cart.setOnClickListener {
            viewModel.openCartFragment()
        }
    }

    private fun initTabLayout() {
        adapter = ProductDetailsTabsAdapter(requireActivity())
        binding.pager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.customView =
                ViewProductDetailsTabTextBinding.inflate(LayoutInflater.from(context)).root

            tab.text = when (position) {
                0 -> getString(R.string.product_details_shop_tab_title)
                1 -> getString(R.string.product_details_details_tab_title)
                2 -> getString(R.string.product_details_features_tab_title)
                else -> "null"
            }
        }.attach()

        regularTypeFace = ResourcesCompat.getFont(requireContext(), io.github.grishaninvyacheslav.core_ui.R.font.mark_pro_regular)!!
        boldTypeFace = ResourcesCompat.getFont(requireContext(), io.github.grishaninvyacheslav.core_ui.R.font.mark_pro_bold)!!
        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                (tab.customView as TextView).apply {
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
                    typeface = boldTypeFace
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                (tab.customView as TextView).apply {
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.blue_half_opacity))
                    typeface = regularTypeFace
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                onTabSelected(tab)
            }
        })

        binding.tabLayout.getTabAt(0)!!.select()
    }

    private fun initObservers() {
        viewModel.productState.observe(viewLifecycleOwner) { renderProductState(it) }
    }

    private fun renderProductState(state: ProductState) {
        when (state) {
            ProductState.Loading -> {}
            is ProductState.Success -> {
                initProductImagesList(state.details.images.toProductImageEntitiesList())
                binding.name.text = state.details.title
                binding.rating.rating = state.details.rating
            }
            is ProductState.Error -> showErrorMessage(state.error)
        }
    }

    private fun initProductImagesList(categories: List<ProductImageEntity>) = with(binding) {
        productImagesList.adapter = ProductImagesListAdapter().apply { items = categories }
        productImagesList.offscreenPageLimit = 3

        val pageMargin = resources.getDimensionPixelOffset(R.dimen.view_page_margin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.view_page_offset).toFloat()

        productImagesList.setPageTransformer { page, position ->
            val myOffset: Float = position * -(2 * pageOffset + pageMargin)
            page.scaleY = 1 - abs(position) * (1F - 279F / 335F)
            when {
                position < -1 -> page.translationX = -myOffset
                position <= 1 -> page.translationX = myOffset
                else -> page.translationX = myOffset
            }
        }
    }

    private lateinit var adapter: ProductDetailsTabsAdapter

    lateinit var regularTypeFace: Typeface
    lateinit var boldTypeFace: Typeface

    private val router: Router by inject()

    private val viewModel: ProductDetailsViewModel by viewModel()
}