package io.github.grishaninvyacheslav.network.data.data_sources

import io.github.grishaninvyacheslav.network.data.data_entity.cart.CartEntity
import io.github.grishaninvyacheslav.network.data.data_entity.ExplorerDataEntity
import io.github.grishaninvyacheslav.network.data.data_entity.ProductDetailsEntity
import retrofit2.Call
import retrofit2.http.GET

interface IMockDataSource {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun explorer(): Call<ExplorerDataEntity>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun productDetails(): Call<ProductDetailsEntity>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun cart(): Call<CartEntity>
}