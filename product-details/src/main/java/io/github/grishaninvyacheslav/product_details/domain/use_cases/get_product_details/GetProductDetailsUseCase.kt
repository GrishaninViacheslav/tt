package io.github.grishaninvyacheslav.product_details.domain.use_cases.get_product_details

import io.github.grishaninvyacheslav.network.data.data_entity.ProductDetailsEntity

interface GetProductDetailsUseCase {
    suspend operator fun invoke(): ProductDetailsEntity
}