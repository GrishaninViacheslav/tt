package io.github.grishaninvyacheslav.product_details.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import io.github.grishaninvyacheslav.core_ui.ui.BaseFragment
import io.github.grishaninvyacheslav.network.data.data_entity.ProductDetailsEntity
import io.github.grishaninvyacheslav.product_details.R
import io.github.grishaninvyacheslav.product_details.databinding.FragmentProductDetailsTabBinding
import io.github.grishaninvyacheslav.product_details.ui.view_models.ProductDetailsViewModel
import io.github.grishaninvyacheslav.product_details.ui.view_models.ProductState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailTabFragment :
    BaseFragment<FragmentProductDetailsTabBinding>(FragmentProductDetailsTabBinding::inflate) {

    companion object {
        fun newInstance() = ProductDetailTabFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.productState.observe(viewLifecycleOwner) { renderProductState(it) }
    }

    private fun renderProductState(state: ProductState) {
        when (state) {
            ProductState.Loading -> {}
            is ProductState.Success -> initView(state.details)
            is ProductState.Error -> showErrorMessage(state.error)
        }
    }

    private fun initView(details: ProductDetailsEntity) = with(binding) {
        cpuValue.text = details.CPU
        cameraValue.text = details.camera
        ssdValue.text = details.ssd
        sdValue.text = details.sd
        details.color.getOrNull(0)?.let {
            colorOption1.setColorFilter(Color.parseColor(it))
        }
        details.color.getOrNull(1)?.let {
            colorOption2.setColorFilter(Color.parseColor(it))
            colorOption2.isVisible = true
        } ?: run {
            colorOption2.isVisible = false
        }
        details.capacity.getOrNull(0)?.let {
            capacityOption1.text = String.format(getString(R.string.capacity_format_string), it)
        }
        details.capacity.getOrNull(1)?.let {
            capacityOption2.text = String.format(getString(R.string.capacity_format_string), it)
            capacityOption2.isVisible = true
        } ?: run {
            capacityOption2.isVisible = false
        }

        colorOption1.setOnClickListener {
            colorOption1Check.isVisible = true
            colorOption2Check.isVisible = false
        }

        colorOption2.setOnClickListener {
            colorOption1Check.isVisible = false
            colorOption2Check.isVisible = true
        }
    }

    private val viewModel: ProductDetailsViewModel by viewModel()
}