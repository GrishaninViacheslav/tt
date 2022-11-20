package io.github.grishaninvyacheslav.cart.di

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.cart.domain.repositories.ICartRepository
import io.github.grishaninvyacheslav.cart.domain.use_cases.NavigateToCartUseCaseImpl
import io.github.grishaninvyacheslav.cart.domain.use_cases.get_cart.GetCartUseCase
import io.github.grishaninvyacheslav.cart.domain.use_cases.get_cart.GetCartUseCaseImpl
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToCartUseCase
import org.koin.dsl.module

val cartUseCasesModule = module {
    factory { provideNavigateToCart(get()) }
    factory { provideGetCart(get()) }
}

fun provideNavigateToCart(router: Router): NavigateToCartUseCase = NavigateToCartUseCaseImpl(router)
fun provideGetCart(cartRepository: ICartRepository): GetCartUseCase = GetCartUseCaseImpl(cartRepository)