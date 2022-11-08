package io.github.grishaninvyacheslav.product_details.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.grishaninvyacheslav.core_ui.ui.BaseViewModel
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToCartUseCase
import io.github.grishaninvyacheslav.product_details.data.IProductsProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productsProvider: IProductsProvider,
    private val navigateToCartUseCase: NavigateToCartUseCase
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

    fun openCartFragment() {
        navigateToCartUseCase()
    }
}