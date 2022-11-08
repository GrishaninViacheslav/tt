package io.github.grishaninvyacheslav.product_details.utils

import io.github.grishaninvyacheslav.network.data.data_entity.ProductImageEntity

fun List<String>.toProductImageEntitiesList(): List<ProductImageEntity> =
    this.map { ProductImageEntity(it) }