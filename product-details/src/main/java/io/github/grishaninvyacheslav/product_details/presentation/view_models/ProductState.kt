package io.github.grishaninvyacheslav.product_details.presentation.view_models

import io.github.grishaninvyacheslav.network.data.data_entity.ProductDetailsEntity

sealed class ProductState {
    object Loading : ProductState()
    data class Success(val details: ProductDetailsEntity) : ProductState()
    data class Error(val error: Throwable) : ProductState()
}