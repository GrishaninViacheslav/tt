package io.github.grishaninvyacheslav.product_details.domain.use_cases

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import io.github.grishaninvyacheslav.product_details.ui.fragments.ProductDetailsFragment

class NavigateToProductDetailsUseCaseImpl(private val router: Router) :
    NavigateToProductDetailsUseCase {

    override fun invoke() {
        val productDetailsFragment = FragmentScreen { ProductDetailsFragment.newInstance() }
        router.navigateTo(productDetailsFragment)
    }
}