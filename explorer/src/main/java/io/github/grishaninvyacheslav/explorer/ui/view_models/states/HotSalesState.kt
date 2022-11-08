package io.github.grishaninvyacheslav.explorer.ui.view_models.states

import io.github.grishaninvyacheslav.network.data.data_entity.HotSaleEntity

sealed class HotSalesState {
    object Loading: HotSalesState()
    data class Success(val hotSales: List<HotSaleEntity>): HotSalesState()
    data class Error(val error: Throwable): HotSalesState()
}