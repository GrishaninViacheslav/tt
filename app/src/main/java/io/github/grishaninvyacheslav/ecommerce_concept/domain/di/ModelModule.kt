package io.github.grishaninvyacheslav.ecommerce_concept.domain.di

import android.content.Context
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.products.IProductsProvider
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.products.ProductsProvider
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.IResourcesProvider
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.ResourcesProvider
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.cart.CartRepository
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.cart.ICartRepository
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.explorer.ExplorerRepository
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.explorer.IExplorerRepository
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.product_categories.IProductCategoriesRepository
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.product_categories.ProductCategoriesRepository
import org.koin.dsl.module

val modelModule = module {
    single { provideProductCategoriesRepository() }
    single { provideExplorerRepository(get(), get()) }
    single { provideProductsProvider(get(), get()) }
    single { provideCartRepository(get()) }
    single { provideResourcesProvider(get()) }
}

fun provideProductCategoriesRepository(): IProductCategoriesRepository =
    ProductCategoriesRepository()

fun provideExplorerRepository(
    explorerApi: IMockDataSource,
    resourcesProvider: IResourcesProvider
): IExplorerRepository =
    ExplorerRepository(explorerApi, resourcesProvider)

fun provideProductsProvider(
    explorerApi: IMockDataSource,
    resourcesProvider: IResourcesProvider
): IProductsProvider =
    ProductsProvider(explorerApi, resourcesProvider)

fun provideCartRepository(
    explorerApi: IMockDataSource,
): ICartRepository =
    CartRepository(explorerApi)

fun provideResourcesProvider(context: Context): IResourcesProvider = ResourcesProvider(context)