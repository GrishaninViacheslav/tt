package io.github.grishaninvyacheslav.ecommerce_concept.utills

import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerPageEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductImageEntity

fun List<BestSellerEntity>.toBestSellersPages(pageSize: Int): List<BestSellerPageEntity> {
    val pageList = mutableListOf<BestSellerPageEntity>()
    var currentPage = mutableListOf<BestSellerEntity>()
    for (bestSellerEntity in this) {
        currentPage.add(bestSellerEntity)
        if (currentPage.size == pageSize) {
            pageList.add(BestSellerPageEntity(currentPage.toList()))
            currentPage.clear()
        }
    }
    if (currentPage.isNotEmpty()) {
        pageList.add(BestSellerPageEntity(currentPage))
    }
    return pageList
}

fun List<String>.toProductImageEntitiesList(): List<ProductImageEntity> =
    this.map { ProductImageEntity(it) }