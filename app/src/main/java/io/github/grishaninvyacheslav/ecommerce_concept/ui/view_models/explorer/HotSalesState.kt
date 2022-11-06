package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.explorer

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.HotSaleEntity

sealed class HotSalesState {
    object Loading: HotSalesState()
    data class Success(val hotSales: List<HotSaleEntity>): HotSalesState()
    data class Error(val error: Throwable): HotSalesState()
}