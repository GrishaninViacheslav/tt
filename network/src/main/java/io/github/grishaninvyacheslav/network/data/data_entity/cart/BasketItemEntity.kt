package io.github.grishaninvyacheslav.network.data.data_entity.cart

import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem

data class BasketItemEntity(
    val id: String,
    val images: String,
    val price: Int,
    val title: String
): DisplayableItem