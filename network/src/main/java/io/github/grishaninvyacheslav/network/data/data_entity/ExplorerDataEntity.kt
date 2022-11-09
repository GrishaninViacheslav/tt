package io.github.grishaninvyacheslav.network.data.data_entity

import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerEntity

data class ExplorerDataEntity(
    val home_store: List<HotSaleEntity>,
    val best_seller: List<BestSellerEntity>
)