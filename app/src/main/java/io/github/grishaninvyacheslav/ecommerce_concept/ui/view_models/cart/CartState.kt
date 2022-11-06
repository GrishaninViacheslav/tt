package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.cart

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.CartEntity

sealed class CartState {
    object Loading : CartState()
    data class Success(val cart: CartEntity?) : CartState()
    data class Error(val error: Throwable) : CartState()
}