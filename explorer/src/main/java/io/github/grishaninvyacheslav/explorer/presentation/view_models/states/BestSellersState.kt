package io.github.grishaninvyacheslav.explorer.presentation.view_models.states

import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerEntity

sealed class BestSellersState {
    object Loading : BestSellersState()
    data class Success(val bestSellers: List<BestSellerEntity>) : BestSellersState()
    data class Error(val error: Throwable) : BestSellersState()
}