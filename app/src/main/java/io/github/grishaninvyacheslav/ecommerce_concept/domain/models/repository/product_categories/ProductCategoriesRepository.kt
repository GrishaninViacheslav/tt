package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.product_categories

import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductCategoryEntity

class ProductCategoriesRepository: IProductCategoriesRepository {
    private val categories = listOf(
        ProductCategoryEntity(0, "Phones", R.drawable.ic_category_phones, true),
        ProductCategoryEntity(1,"Computer", R.drawable.ic_category_computer, false),
        ProductCategoryEntity(2,"Health", R.drawable.ic_category_health, false),
        ProductCategoryEntity(3,"Books", R.drawable.ic_category_books, false)
    )

    override suspend fun getCategories(): List<ProductCategoryEntity> {
        return categories
    }

    override suspend fun selectCategory(selectedCategoryIndex: Int): List<ProductCategoryEntity> {
        for(category in categories){
            category.isSelected = category.index == selectedCategoryIndex
        }
        return categories
    }
}