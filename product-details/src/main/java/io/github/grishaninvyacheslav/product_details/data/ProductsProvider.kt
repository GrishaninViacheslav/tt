package io.github.grishaninvyacheslav.product_details.data

import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.network.data.data_entity.ProductDetailsEntity
import io.github.grishaninvyacheslav.product_details.R
import io.github.grishaninvyacheslav.product_details.domain.providers.IProductsProvider
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.lang.RuntimeException

class ProductsProvider(
    private val explorerApi: IMockDataSource,
    private val resourcesProvider: IResourcesProvider
) : IProductsProvider {
    private var productsBuffer: ProductDetailsEntity? = null

    override suspend fun getProductDetails(): ProductDetailsEntity {
        productsBuffer?.let { return it }
        with(explorerApi.productDetails().awaitResponse()) {
            when (code()) {
                200 -> {
                    if (body() == null) {
                        throw EmptyResponseException()
                    }
                    productsBuffer = body()
                    return productsBuffer!!
                }
                else -> throw HttpException(this)
            }
        }
    }

    inner class EmptyResponseException :
        RuntimeException(resourcesProvider.getString(R.string.no_data_exception))
}