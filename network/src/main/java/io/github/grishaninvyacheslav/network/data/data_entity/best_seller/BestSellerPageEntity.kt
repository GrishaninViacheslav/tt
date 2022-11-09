package io.github.grishaninvyacheslav.network.data.data_entity.best_seller

import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem

data class BestSellerPageEntity(
    val items: List<BestSellerEntity>
) : DisplayableItem
