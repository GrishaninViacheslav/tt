package io.github.grishaninvyacheslav.product_details.domain.use_cases.get_product_details

import io.github.grishaninvyacheslav.product_details.domain.providers.IProductsProvider

class GetProductDetailsUseCaseImpl(
    private val productProvider: IProductsProvider
): GetProductDetailsUseCase {
    override suspend fun invoke() = productProvider.getProductDetails()
}