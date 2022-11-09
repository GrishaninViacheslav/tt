package io.github.grishaninvyacheslav.network.data.data_entity.cart

data class CartEntity(
    val basket: List<BasketItemEntity>,
    val delivery: String,
    val id: String,
    val total: String
)