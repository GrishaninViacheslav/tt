package io.github.grishaninvyacheslav.explorer.domain.use_cases.filter_categories

import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.R
import io.github.grishaninvyacheslav.network.data.data_entity.ProductCategoryEntity

class FilterCategoriesUseCaseImpl(private val resourcesProvider: IResourcesProvider): FilterCategoriesUseCase {
    override suspend fun getCategories(): List<ProductCategoryEntity> {
        return categories
    }

    override suspend fun selectCategory(selectedCategoryIndex: Int): List<ProductCategoryEntity> {
        for(category in categories){
            category.isSelected = category.index == selectedCategoryIndex
        }
        return categories
    }

    private val categories by lazy {
        listOf(
            ProductCategoryEntity(0, resourcesProvider.getString(R.string.add_address_title), R.drawable.ic_category_phones, true),
            ProductCategoryEntity(1, resourcesProvider.getString(R.string.computer_filter), R.drawable.ic_category_computer, false),
            ProductCategoryEntity(2, resourcesProvider.getString(R.string.health_filter), R.drawable.ic_category_health, false),
            ProductCategoryEntity(3, resourcesProvider.getString(R.string.books_filter), R.drawable.ic_category_books, false)
        )
    }
}