package io.github.grishaninvyacheslav.cart.data

import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.network.data.data_entity.cart.CartEntity
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