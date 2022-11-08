package io.github.grishaninvyacheslav.cart.di

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.cart.domain.use_cases.NavigateToCartUseCaseImpl
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToCartUseCase
import org.koin.dsl.module

val cartUseCasesModule = module {
    factory { provideNavigateToCart(get()) }
}

fun provideNavigateToCart(router: Router): NavigateToCartUseCase = NavigateToCartUseCaseImpl(router)