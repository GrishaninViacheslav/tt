package io.github.grishaninvyacheslav.cart.di

import io.github.grishaninvyacheslav.cart.presentation.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartViewModelsModule = module {
    viewModel { CartViewModel(get()) }
}