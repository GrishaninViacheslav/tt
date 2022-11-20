package io.github.grishaninvyacheslav.ecommerce_concept.di

import io.github.grishaninvyacheslav.cart.domain.repositories.ICartRepository
import io.github.grishaninvyacheslav.ecommerce_concept.domain.use_cases.GetItemsInCartNumberUseCase
import io.github.grishaninvyacheslav.ecommerce_concept.domain.use_cases.GetItemsInCartNumberUseCaseImpl
import org.koin.dsl.module

val mainUseCasesModule = module {
    factory { provideGetItemsInCartNumber(get()) }
}

fun provideGetItemsInCartNumber(cartRepository: ICartRepository): GetItemsInCartNumberUseCase = GetItemsInCartNumberUseCaseImpl(cartRepository)