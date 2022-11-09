package io.github.grishaninvyacheslav.explorer.domain.use_cases.explorer

import io.github.grishaninvyacheslav.network.data.data_entity.HotSaleEntity
import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerEntity

interface ExplorerUseCases {
    suspend fun getHotSales(): List<HotSaleEntity>
    suspend fun getBestSellers(): List<BestSellerEntity>
}