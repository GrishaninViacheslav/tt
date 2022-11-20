package io.github.grishaninvyacheslav.cart.di

import io.github.grishaninvyacheslav.cart.presentation.adapters.BasketAdapterDelegate
import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import org.koin.dsl.module

val cartAdaptersModule = module {
    single { provideBasketAdapterDelegate(get(), get()) }
}

fun provideBasketAdapterDelegate(
    resourcesProvider: IResourcesProvider,
    navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
): BasketAdapterDelegate =
    BasketAdapterDelegate(resourcesProvider, navigateToProductDetailsUseCase)