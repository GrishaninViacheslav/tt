package io.github.grishaninvyacheslav.ecommerce_concept.ui

sealed class BasketSizeState {
    object Loading : BasketSizeState()
    data class Success(val basketSize: Int) : BasketSizeState()
    data class Error(val error: Throwable) : BasketSizeState()
}