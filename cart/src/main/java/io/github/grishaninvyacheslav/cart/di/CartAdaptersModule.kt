package io.github.grishaninvyacheslav.cart.di

import io.github.grishaninvyacheslav.cart.presentation.adapters.BasketAdapter
import io.github.grishaninvyacheslav.cart.presentation.adapters.BasketAdapterDelegate
import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import org.koin.dsl.module

val cartAdaptersModule = module {
    single { provideBasketAdapter(get(), get()) }
}

fun provideBasketAdapter(
    resourcesProvider: IResourcesProvider,
    navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
): BasketAdapter =
    BasketAdapter(
        BasketAdapterDelegate(
            resourcesProvider,
            navigateToProductDetailsUseCase
        )
    )