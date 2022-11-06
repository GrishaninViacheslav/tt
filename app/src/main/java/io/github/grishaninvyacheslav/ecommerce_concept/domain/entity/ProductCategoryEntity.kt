package io.github.grishaninvyacheslav.ecommerce_concept.domain.entity

import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem

data class ProductCategoryEntity(
    val index: Int,
    val title: String,
    val icon: Int,
    var isSelected: Boolean
): DisplayableItem