package io.github.grishaninvyacheslav.ecommerce_concept.domain.use_cases

import io.github.grishaninvyacheslav.cart.data.ICartRepository

class GetItemsInCartNumberUseCaseImpl(
    private val cartRepository: ICartRepository
) : GetItemsInCartNumberUseCase {
    override suspend fun invoke() = cartRepository.getCart()?.basket?.size ?: 0
}