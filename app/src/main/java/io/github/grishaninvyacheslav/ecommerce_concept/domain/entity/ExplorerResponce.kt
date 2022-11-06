package io.github.grishaninvyacheslav.ecommerce_concept.domain.entity

data class ExplorerDataEntity(
    val home_store: List<HotSaleEntity>,
    val best_seller: List<BestSellerEntity>
)