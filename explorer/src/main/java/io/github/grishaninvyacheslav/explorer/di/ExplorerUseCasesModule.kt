package io.github.grishaninvyacheslav.explorer.di

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.core_ui.data.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.domain.use_cases.ReplaceWithExplorerUseCaseImpl
import io.github.grishaninvyacheslav.explorer.domain.use_cases.filter_categories.FilterCategoriesUseCase
import io.github.grishaninvyacheslav.explorer.domain.use_cases.filter_categories.FilterCategoriesUseCaseImpl
import io.github.grishaninvyacheslav.navigation.domain.use_cases.ReplaceWithExplorerUseCase
import org.koin.dsl.module

val explorerUseCasesModule = module {
    factory { provideReplaceWithExplorer(get()) }
    factory { provideFilterCategories(get()) }
}

fun provideReplaceWithExplorer(router: Router): ReplaceWithExplorerUseCase =
    ReplaceWithExplorerUseCaseImpl(router)

fun provideFilterCategories(resourcesProvider: IResourcesProvider): FilterCategoriesUseCase =
    FilterCategoriesUseCaseImpl(resourcesProvider)