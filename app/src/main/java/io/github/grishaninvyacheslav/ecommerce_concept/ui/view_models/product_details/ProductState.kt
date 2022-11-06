package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.product_details

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductDetailsEntity

sealed class ProductState {
    object Loading : ProductState()
    data class Success(val details: ProductDetailsEntity) : ProductState()
    data class Error(val error: Throwable) : ProductState()
}