package io.github.grishaninvyacheslav.cart.di

import io.github.grishaninvyacheslav.cart.data.CartRepository
import io.github.grishaninvyacheslav.cart.domain.repositories.ICartRepository
import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import org.koin.dsl.module

val cartModelsModule = module {
    single { provideCartRepository(get()) }
}

fun provideCartRepository(
    explorerApi: IMockDataSource,
): ICartRepository =
    CartRepository(explorerApi)