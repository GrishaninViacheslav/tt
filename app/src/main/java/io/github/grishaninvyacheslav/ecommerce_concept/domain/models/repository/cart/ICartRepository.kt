package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.cart

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.CartEntity


interface ICartRepository {
    suspend fun getCart(): CartEntity?
}