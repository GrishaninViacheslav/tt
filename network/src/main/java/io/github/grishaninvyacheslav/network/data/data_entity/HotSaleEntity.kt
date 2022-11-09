package io.github.grishaninvyacheslav.network.data.data_entity

data class HotSaleEntity(
    val id: Int,
    val is_new: Boolean = false,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
): DisplayableItem