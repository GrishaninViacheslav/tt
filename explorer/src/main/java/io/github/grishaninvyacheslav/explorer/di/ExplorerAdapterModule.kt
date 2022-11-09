package io.github.grishaninvyacheslav.explorer.di

import io.github.grishaninvyacheslav.core_ui.data.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.ui.adapters.BestSellersAdapterDelegate
import io.github.grishaninvyacheslav.explorer.ui.adapters.CategoriesAdapterDelegate
import io.github.grishaninvyacheslav.explorer.ui.adapters.HotSalesAdapterDelegate
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import org.koin.dsl.module

val explorerAdapterModule = module {
    single { provideBestSellersAdapterDelegate(get(), get()) }
    single { provideCategoriesAdapterDelegate(get()) }
    single { provideHotSalesAdapterDelegate(get()) }
}

fun provideBestSellersAdapterDelegate(
    resourcesProvider: IResourcesProvider,
    navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
): BestSellersAdapterDelegate =
    BestSellersAdapterDelegate(resourcesProvider, navigateToProductDetailsUseCase)

fun provideCategoriesAdapterDelegate(
    resourcesProvider: IResourcesProvider
): CategoriesAdapterDelegate =
    CategoriesAdapterDelegate(resourcesProvider)

fun provideHotSalesAdapterDelegate(
    navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
): HotSalesAdapterDelegate =
    HotSalesAdapterDelegate(navigateToProductDetailsUseCase)