package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.products

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductDetailsEntity

interface IProductsProvider {
    suspend fun getProductDetails(): ProductDetailsEntity
}