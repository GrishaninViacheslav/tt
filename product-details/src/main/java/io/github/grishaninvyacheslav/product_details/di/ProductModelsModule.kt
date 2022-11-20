package io.github.grishaninvyacheslav.product_details.di

import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.product_details.domain.providers.IProductsProvider
import io.github.grishaninvyacheslav.product_details.data.ProductsProvider
import org.koin.dsl.module

val productModelsModule = module {
    single { provideProductsProvider(get(), get()) }
}

fun provideProductsProvider(
    explorerApi: IMockDataSource,
    resourcesProvider: IResourcesProvider
): IProductsProvider =
    ProductsProvider(
        explorerApi,
        resourcesProvider
    )
