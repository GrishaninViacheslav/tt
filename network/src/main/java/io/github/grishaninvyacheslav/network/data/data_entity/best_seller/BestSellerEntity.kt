package io.github.grishaninvyacheslav.network.data.data_entity.best_seller

data class BestSellerEntity(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)