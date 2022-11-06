package io.github.grishaninvyacheslav.ecommerce_concept.domain.entity

import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem

data class BestSellerPageEntity(
    val items: List<BestSellerEntity>
) : DisplayableItem

data class BestSellerEntity(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)