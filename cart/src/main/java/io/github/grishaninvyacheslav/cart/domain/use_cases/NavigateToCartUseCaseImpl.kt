package io.github.grishaninvyacheslav.cart.domain.use_cases

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.github.grishaninvyacheslav.cart.ui.CartFragment
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToCartUseCase

class NavigateToCartUseCaseImpl(private val router: Router): NavigateToCartUseCase {
    override fun invoke() {
        val cart = FragmentScreen { CartFragment.newInstance() }
        router.navigateTo(cart)
    }
}