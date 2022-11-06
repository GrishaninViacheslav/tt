package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.explorer

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerEntity

sealed class BestSellersState {
    object Loading : BestSellersState()
    data class Success(val bestSellers: List<BestSellerEntity>) : BestSellersState()
    data class Error(val error: Throwable) : BestSellersState()
}