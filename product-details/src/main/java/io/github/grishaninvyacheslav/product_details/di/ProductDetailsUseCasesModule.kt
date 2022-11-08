package io.github.grishaninvyacheslav.product_details.di

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import io.github.grishaninvyacheslav.product_details.domain.use_cases.NavigateToProductDetailsUseCaseImpl
import org.koin.dsl.module

val productDetailsUseCasesModule = module {
    factory { productDetailsUseCasesModule(get()) }
}

fun productDetailsUseCasesModule(router: Router): NavigateToProductDetailsUseCase = NavigateToProductDetailsUseCaseImpl(router)