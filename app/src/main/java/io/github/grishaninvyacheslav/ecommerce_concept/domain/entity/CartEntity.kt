package io.github.grishaninvyacheslav.ecommerce_concept.domain.entity

import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem

data class CartEntity(
    val basket: List<BasketItemEntity>,
    val delivery: String,
    val id: String,
    val total: String
)

data class BasketItemEntity(
    val id: String,
    val images: String,
    val price: Int,
    val title: String
): DisplayableItem