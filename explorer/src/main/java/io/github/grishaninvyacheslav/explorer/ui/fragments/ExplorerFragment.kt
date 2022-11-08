package io.github.grishaninvyacheslav.explorer.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import io.github.grishaninvyacheslav.core_ui.ui.BaseFragment
import io.github.grishaninvyacheslav.core_ui.ui.IBottomNavigation
import io.github.grishaninvyacheslav.core_ui.ui.adapters.ListAdapter
import io.github.grishaninvyacheslav.explorer.databinding.FragmentExplorerBinding
import io.github.grishaninvyacheslav.explorer.ui.adapters.BestSellersAdapterDelegate
import io.github.grishaninvyacheslav.explorer.ui.adapters.CategoriesAdapterDelegate
import io.github.grishaninvyacheslav.explorer.ui.adapters.HotSalesAdapterDelegate
import io.github.grishaninvyacheslav.explorer.ui.view_models.states.BestSellersState
import io.github.grishaninvyacheslav.explorer.ui.view_models.states.CategoriesState
import io.github.grishaninvyacheslav.explorer.ui.view_models.ExplorerViewModel
import io.github.grishaninvyacheslav.explorer.ui.view_models.states.HotSalesState
import io.github.grishaninvyacheslav.explorer.utills.toBestSellersPages
import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerPageEntity
import io.github.grishaninvyacheslav.network.data.data_entity.HotSaleEntity
import io.github.grishaninvyacheslav.network.data.data_entity.ProductCategoryEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExplorerFragment :
    BaseFragment<FragmentExplorerBinding>(FragmentExplorerBinding::inflate) {

    companion object {
        private const val BEST_SELLERS_PAGE_SIZE = 4

        fun newInstance() = ExplorerFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as IBottomNavigation).isNavigationVisible = true
        binding.filterOptions.setOnClickListener {
            showBottomSheetDialog()
        }
        initObservers()
    }

    private fun initObservers() = with(binding) {
        viewModel.categoriesState.observe(viewLifecycleOwner) { renderCategoriesState(it) }
        viewModel.hotSalesState.observe(viewLifecycleOwner) { renderHotSalesState(it) }
        viewModel.bestSellersState.observe(viewLifecycleOwner) { renderBestSellersState(it) }
    }

    @SuppressLint("NotifyDataSetChanged") // NotifyDataSetChanged потому что при выборе категории обноваляется весь data set, так как у каждой категории меняется значение поля isSelected
    private fun renderCategoriesState(state: CategoriesState) = with(binding) {
        when (state) {
            CategoriesState.Loading -> {}
            is CategoriesState.Success -> {
                if (categoryList.adapter == null) {
                    initCategoriesList(state.categories)
                } else {
                    (categoryList.adapter as ListAdapter).items = state.categories
                    categoryList.adapter!!.notifyDataSetChanged()
                }
            }
            is CategoriesState.Error -> showErrorMessage(state.error)
        }
    }

    private fun renderHotSalesState(state: HotSalesState) = with(binding) {
        when (state) {
            HotSalesState.Loading -> {
                hotSalesProgressBar.isVisible = true
            }
            is HotSalesState.Success -> {
                hotSalesProgressBar.isVisible = false
                initHotSalesList(state.hotSales)
            }
            is HotSalesState.Error -> {
                hotSalesProgressBar.isVisible = false
                showErrorMessage(state.error)
            }
        }
    }

    private fun renderBestSellersState(state: BestSellersState) = with(binding) {
        when (state) {
            BestSellersState.Loading -> {
                bestSellersProgressBar.isVisible = true
            }
            is BestSellersState.Success -> {
                bestSellersProgressBar.isVisible = false
                initBestSellersList(state.bestSellers.toBestSellersPages(BEST_SELLERS_PAGE_SIZE))
            }
            is BestSellersState.Error -> {
                bestSellersProgressBar.isVisible = false
                showErrorMessage(state.error)
            }
        }
    }

    private fun showBottomSheetDialog() {
        FilterBottomSheetDialog(requireContext()).show()
    }

    private fun initCategoriesList(productCategories: List<ProductCategoryEntity>) = with(binding) {
        categoryList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryList.adapter = ListAdapter(categoriesAdapterDelegate.adapterDelegate).apply {
            items = productCategories
        }
    }

    private fun initHotSalesList(hotSales: List<HotSaleEntity>) = with(binding) {
        hotSalesList.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        hotSalesList.adapter =
            ListAdapter(hotSalesAdapterDelegate.adapterDelegate).apply { items = hotSales }
        hotSalesList.offscreenPageLimit = 1
    }

    private fun initBestSellersList(bestSellers: List<BestSellerPageEntity>) = with(binding) {
        bestSellersList.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        bestSellersList.adapter =
            ListAdapter(bestSalesAdapterDelegate.adapterDelegate).apply { items = bestSellers }
        bestSellersList.offscreenPageLimit = 1
    }

    private val categoriesAdapterDelegate = CategoriesAdapterDelegate {
        viewModel.selectCategory(it.index)
    }
    private val hotSalesAdapterDelegate = HotSalesAdapterDelegate()
    private val bestSalesAdapterDelegate = BestSellersAdapterDelegate()

    private val viewModel: ExplorerViewModel by viewModel()
}