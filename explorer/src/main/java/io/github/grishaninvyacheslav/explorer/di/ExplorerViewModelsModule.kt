package io.github.grishaninvyacheslav.explorer.di

import io.github.grishaninvyacheslav.explorer.ui.view_models.ExplorerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val explorerViewModelsModule = module {
    viewModel { ExplorerViewModel(get(), get()) }
}