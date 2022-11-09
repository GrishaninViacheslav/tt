package io.github.grishaninvyacheslav.cart.domain.use_cases.get_cart

import io.github.grishaninvyacheslav.network.data.data_entity.cart.CartEntity

interface GetCartUseCase {
    suspend operator fun invoke(): CartEntity?
}