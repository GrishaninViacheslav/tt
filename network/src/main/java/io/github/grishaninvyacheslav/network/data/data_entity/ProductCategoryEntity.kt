package io.github.grishaninvyacheslav.network.data.data_entity

data class ProductCategoryEntity(
    val index: Int,
    val title: String,
    val icon: Int,
    var isSelected: Boolean
): DisplayableItem