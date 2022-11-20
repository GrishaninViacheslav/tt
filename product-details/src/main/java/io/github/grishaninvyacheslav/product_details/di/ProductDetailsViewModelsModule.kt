package io.github.grishaninvyacheslav.product_details.di

import io.github.grishaninvyacheslav.product_details.presentation.view_models.ProductDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailsViewModelsModule = module {
    viewModel { ProductDetailsViewModel(get(), get()) }
}