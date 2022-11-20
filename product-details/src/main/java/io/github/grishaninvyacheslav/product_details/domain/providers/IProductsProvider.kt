package io.github.grishaninvyacheslav.product_details.domain.providers

import io.github.grishaninvyacheslav.network.data.data_entity.ProductDetailsEntity

interface IProductsProvider {
    suspend fun getProductDetails(): ProductDetailsEntity
}