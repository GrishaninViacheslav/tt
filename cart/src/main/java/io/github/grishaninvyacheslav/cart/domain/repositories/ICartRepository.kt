package io.github.grishaninvyacheslav.cart.domain.repositories

import io.github.grishaninvyacheslav.network.data.data_entity.cart.CartEntity

interface ICartRepository {
    suspend fun getCart(): CartEntity?
}