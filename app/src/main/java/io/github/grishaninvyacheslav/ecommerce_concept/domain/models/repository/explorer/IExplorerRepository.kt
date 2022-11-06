package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.explorer

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.HotSaleEntity

interface IExplorerRepository {
    suspend fun getHotSales(): List<HotSaleEntity>
    suspend fun getBestSellers(): List<BestSellerEntity>
}