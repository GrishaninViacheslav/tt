package io.github.grishaninvyacheslav.ecommerce_concept.domain.entity

import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem

data class HotSaleEntity(
    val id: Int,
    val is_new: Boolean = false,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
): DisplayableItem