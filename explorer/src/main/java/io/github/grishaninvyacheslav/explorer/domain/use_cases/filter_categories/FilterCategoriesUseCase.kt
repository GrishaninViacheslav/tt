package io.github.grishaninvyacheslav.explorer.domain.use_cases.filter_categories

import io.github.grishaninvyacheslav.network.data.data_entity.ProductCategoryEntity

interface FilterCategoriesUseCase {
    suspend fun getCategories(): List<ProductCategoryEntity>
    suspend fun selectCategory(selectedCategoryIndex: Int): List<ProductCategoryEntity>
}