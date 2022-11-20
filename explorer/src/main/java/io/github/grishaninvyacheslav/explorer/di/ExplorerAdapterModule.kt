package io.github.grishaninvyacheslav.explorer.di

import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.presentation.adapters.best_seller.BestSellersAdapterDelegate
import io.github.grishaninvyacheslav.explorer.presentation.adapters.categories.CategoriesAdapterDelegate
import io.github.grishaninvyacheslav.explorer.presentation.adapters.hot_sales.HotSalesAdapterDelegate
import io.github.grishaninvyacheslav.explorer.presentation.adapters.best_seller.BestSellersAdapter
import io.github.grishaninvyacheslav.explorer.presentation.adapters.categories.CategoriesAdapter
import io.github.grishaninvyacheslav.explorer.presentation.adapters.hot_sales.HotSalesAdapter
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import org.koin.dsl.module

val explorerAdapterModule = module {
    single { provideBestSellersAdapter(get(), get()) }
    single { provideCategoriesAdapter(get()) }
    single { provideHotSalesAdapter(get()) }
}

fun provideBestSellersAdapter(
    resourcesProvider: IResourcesProvider,
    navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
): BestSellersAdapter =
    BestSellersAdapter(
        BestSellersAdapterDelegate(
            resourcesProvider,
            navigateToProductDetailsUseCase
        )
    )

fun provideCategoriesAdapter(
    resourcesProvider: IResourcesProvider
): CategoriesAdapter =
    CategoriesAdapter(CategoriesAdapterDelegate(resourcesProvider))

fun provideHotSalesAdapter(
    navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
): HotSalesAdapter =
    HotSalesAdapter(HotSalesAdapterDelegate(navigateToProductDetailsUseCase))

