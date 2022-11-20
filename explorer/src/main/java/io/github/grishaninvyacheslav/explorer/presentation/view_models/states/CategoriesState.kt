package io.github.grishaninvyacheslav.explorer.presentation.view_models.states

import io.github.grishaninvyacheslav.network.data.data_entity.ProductCategoryEntity

sealed class CategoriesState {
    object Loading: CategoriesState()
    data class Success(val categories: List<ProductCategoryEntity>): CategoriesState()
    data class Error(val error: Throwable): CategoriesState()
}