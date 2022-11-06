package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.products

import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductDetailsEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.data_sources.IMockDataSource
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.IResourcesProvider
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