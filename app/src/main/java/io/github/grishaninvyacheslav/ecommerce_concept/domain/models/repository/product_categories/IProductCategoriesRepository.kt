package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.product_categories

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductCategoryEntity

interface IProductCategoriesRepository {
    suspend fun getCategories(): List<ProductCategoryEntity>
    suspend fun selectCategory(selectedCategoryIndex: Int): List<ProductCategoryEntity>
}