package io.github.grishaninvyacheslav.cart.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.cart.R
import io.github.grishaninvyacheslav.cart.databinding.FragmentCartBinding
import io.github.grishaninvyacheslav.cart.presentation.adapters.BasketAdapter
import io.github.grishaninvyacheslav.core_ui.presentation.BaseFragment
import io.github.grishaninvyacheslav.core_ui.presentation.IBottomNavigation
import io.github.grishaninvyacheslav.network.data.data_entity.cart.BasketItemEntity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment :
    BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    companion object {
        fun newInstance() = CartFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as IBottomNavigation).isNavigationVisible = false
        initView()
        initObservers()
    }

    private fun initView() = with(binding) {
        back.setOnClickListener {
            router.exit()
        }
    }

    private fun initObservers() {
        viewModel.cartState.observe(viewLifecycleOwner) { renderCartState(it) }
    }

    private fun renderCartState(state: CartState) {
        when (state) {
            CartState.Loading -> {}
            is CartState.Success -> {
                state.cart?.let {
                    initBasketList(it.basket)
                    binding.sumValue.text =
                        String.format(getString(R.string.sum_value_format_string), it.total)
                    if (it.delivery == getString(R.string.free_delivery_value)) {
                        binding.deliveryValue.text = it.delivery
                    } else {
                        binding.deliveryValue.text =
                            String.format(getString(R.string.sum_value_format_string), it.delivery)
                    }
                } ?: run { renderEmptyBasket() }
            }
            is CartState.Error -> showErrorMessage(state.error)
        }
    }

    private fun renderEmptyBasket() {
        // TODO("нет дизайна в фигма")
    }

    private fun initBasketList(basketEntities: List<BasketItemEntity>) = with(binding) {
        basketList.layoutManager = LinearLayoutManager(requireContext())
        basketList.adapter = basketAdapter.apply {
            items = basketEntities
        }
    }

    private val basketAdapter: BasketAdapter by inject()

    private val viewModel: CartViewModel by viewModel()

    private val router: Router by inject()
}