package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.cart

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.CartEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.data_sources.IMockDataSource
import retrofit2.HttpException
import retrofit2.awaitResponse

class CartRepository(
    private val explorerApi: IMockDataSource
) : ICartRepository {
    private var cartBuffer: CartEntity? = null

    override suspend fun getCart(): CartEntity? {
        cartBuffer?.let { return it }
        with(explorerApi.cart().awaitResponse()) {
            when (code()) {
                200 -> {
                    cartBuffer = body()
                    return cartBuffer
                }
                else -> throw HttpException(this)
            }
        }
    }
}