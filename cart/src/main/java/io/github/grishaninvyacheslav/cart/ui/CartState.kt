package io.github.grishaninvyacheslav.cart.ui

import io.github.grishaninvyacheslav.network.data.data_entity.cart.CartEntity

sealed class CartState {
    object Loading : CartState()
    data class Success(val cart: CartEntity?) : CartState()
    data class Error(val error: Throwable) : CartState()
}