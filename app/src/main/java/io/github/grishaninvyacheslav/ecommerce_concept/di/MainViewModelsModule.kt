package io.github.grishaninvyacheslav.ecommerce_concept.di

import io.github.grishaninvyacheslav.ecommerce_concept.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelsModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
}