package io.github.grishaninvyacheslav.explorer.utills

import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerEntity
import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerPageEntity

fun List<BestSellerEntity>.toBestSellersPages(pageSize: Int): List<BestSellerPageEntity> {
    val pageList = mutableListOf<BestSellerPageEntity>()
    val currentPage = mutableListOf<BestSellerEntity>()
    for (bestSellerEntity in this) {
        currentPage.add(bestSellerEntity)
        if (currentPage.size == pageSize) {
            pageList.add(
                BestSellerPageEntity(
                    currentPage.toList()
                )
            )
            currentPage.clear()
        }
    }
    if (currentPage.isNotEmpty()) {
        pageList.add(BestSellerPageEntity(currentPage))
    }
    return pageList
}