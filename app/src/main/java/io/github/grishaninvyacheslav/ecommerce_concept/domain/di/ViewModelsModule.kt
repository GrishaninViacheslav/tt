package io.github.grishaninvyacheslav.ecommerce_concept.domain.di

import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.cart.CartViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.explorer.ExplorerViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.main.MainViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.product_details.ProductDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelsModule = module {
    viewModel { ExplorerViewModel(get(), get()) }
    viewModel { ProductDetailsViewModel(get()) }
    viewModel { CartViewModel(get()) }
    viewModel { MainViewModel(get()) }
}