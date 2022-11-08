package io.github.grishaninvyacheslav.explorer.data

import io.github.grishaninvyacheslav.core_ui.data.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.R
import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.network.data.data_entity.best_seller.BestSellerEntity
import io.github.grishaninvyacheslav.network.data.data_entity.HotSaleEntity
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