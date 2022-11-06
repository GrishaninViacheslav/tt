package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.product_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.grishaninvyacheslav.core_ui.presnetation.BaseViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.products.IProductsProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productsProvider: IProductsProvider
) : BaseViewModel() {
    private val mutableProductState: MutableLiveData<ProductState> = MutableLiveData()
    val productState: LiveData<ProductState>
        get() {
            if (mutableProductState.value != null) {
                return mutableProductState
            }
            return mutableProductState.apply {
                mutableProductState.value = ProductState.Loading
                CoroutineScope(Dispatchers.IO + productExceptionHandler).launch {
                    mutableProductState.postValue(
                        ProductState.Success(productsProvider.getProductDetails())
                    )
                }.also { cancelableJobs.add(it) }
            }
        }

    private val productExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableProductState.postValue(ProductState.Error(throwable))
    }
}