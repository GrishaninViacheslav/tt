package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.explorer

import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.HotSaleEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.IResourcesProvider
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.lang.RuntimeException

class ExplorerRepository(
    private val explorerApi: IMockDataSource,
    private val resourcesProvider: IResourcesProvider
) : IExplorerRepository {
    private var hotSalesBuffer: List<HotSaleEntity>? = null
    private var bestSellersBuffer: List<BestSellerEntity>? = null

    override suspend fun getHotSales(): List<HotSaleEntity> {
        hotSalesBuffer?.let { return it }
        with(explorerApi.explorer().awaitResponse()) {
            when (code()) {
                200 -> {
                    if (body()?.home_store == null) {
                        throw EmptyResponseException()
                    }

                    hotSalesBuffer = body()?.home_store
                    bestSellersBuffer = body()?.best_seller

                    return hotSalesBuffer!!
                }
                else -> throw HttpException(this)
            }
        }
    }

    override suspend fun getBestSellers(): List<BestSellerEntity> {
        bestSellersBuffer?.let { return it }
        with(explorerApi.explorer().awaitResponse()) {
            when (code()) {
                200 -> {
                    if (body()?.best_seller == null) {
                        throw EmptyResponseException()
                    }

                    hotSalesBuffer = body()?.home_store
                    bestSellersBuffer = body()?.best_seller

                    return bestSellersBuffer!!
                }
                else -> throw HttpException(this)
            }
        }
    }

    inner class EmptyResponseException :
        RuntimeException(resourcesProvider.getString(R.string.no_data_exception))
}