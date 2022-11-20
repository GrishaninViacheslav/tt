package io.github.grishaninvyacheslav.core_ui.di

import android.content.Context
import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.core_ui.data.ResourcesProvider
import org.koin.dsl.module

val coreModelsModule = module {
    single { provideResourcesProvider(get()) }
}

fun provideResourcesProvider(context: Context): IResourcesProvider =
    ResourcesProvider(context)