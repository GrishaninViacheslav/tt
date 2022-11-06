package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.explorer

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductCategoryEntity

sealed class CategoriesState {
    object Loading: CategoriesState()
    data class Success(val categories: List<ProductCategoryEntity>): CategoriesState()
    data class Error(val error: Throwable): CategoriesState()
}