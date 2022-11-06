package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.main

sealed class BasketSizeState {
    object Loading : BasketSizeState()
    data class Success(val basketSize: Int) : BasketSizeState()
    data class Error(val error: Throwable) : BasketSizeState()
}