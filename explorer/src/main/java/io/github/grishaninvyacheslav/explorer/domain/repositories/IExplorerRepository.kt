package io.github.grishaninvyacheslav.explorer.domain.repositories

import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerEntity
import io.github.grishaninvyacheslav.network.data.data_entity.HotSaleEntity

interface IExplorerRepository {
    suspend fun getHotSales(): List<HotSaleEntity>
    suspend fun getBestSellers(): List<BestSellerEntity>
}