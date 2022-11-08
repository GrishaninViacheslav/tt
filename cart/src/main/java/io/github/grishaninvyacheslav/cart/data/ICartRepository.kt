package io.github.grishaninvyacheslav.cart.data

import io.github.grishaninvyacheslav.network.data.data_entity.cart.CartEntity

interface ICartRepository {
    suspend fun getCart(): CartEntity?
}