package io.github.grishaninvyacheslav.product_details.di

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import io.github.grishaninvyacheslav.product_details.domain.providers.IProductsProvider
import io.github.grishaninvyacheslav.product_details.domain.use_cases.NavigateToProductDetailsUseCaseImpl
import io.github.grishaninvyacheslav.product_details.domain.use_cases.get_product_details.GetProductDetailsUseCase
import io.github.grishaninvyacheslav.product_details.domain.use_cases.get_product_details.GetProductDetailsUseCaseImpl
import org.koin.dsl.module

val productDetailsUseCasesModule = module {
    factory { provideNavigateToProductDetails(get()) }
    factory { provideGetProductDetails(get()) }
}

fun provideNavigateToProductDetails(router: Router): NavigateToProductDetailsUseCase = NavigateToProductDetailsUseCaseImpl(router)
fun provideGetProductDetails(productProvider: IProductsProvider): GetProductDetailsUseCase = GetProductDetailsUseCaseImpl(productProvider)