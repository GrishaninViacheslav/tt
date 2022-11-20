package io.github.grishaninvyacheslav.explorer.di

import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.data.ExplorerRepository
import io.github.grishaninvyacheslav.explorer.domain.repositories.IExplorerRepository
import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import org.koin.dsl.module

val explorerModelsModule = module {
    single { provideExplorerRepository(get(), get()) }
}

fun provideExplorerRepository(
    explorerApi: IMockDataSource,
    resourcesProvider: IResourcesProvider
): IExplorerRepository =
    ExplorerRepository(
        explorerApi,
        resourcesProvider
    )