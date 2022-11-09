package io.github.grishaninvyacheslav.ecommerce_concept.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.grishaninvyacheslav.ecommerce_concept.domain.use_cases.GetItemsInCartNumberUseCase
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToCartUseCase
import io.github.grishaninvyacheslav.navigation.domain.use_cases.ReplaceWithExplorerUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getItemsInCartNumberUseCase: GetItemsInCartNumberUseCase,
    private val replaceWithExplorerUseCase: ReplaceWithExplorerUseCase,
    private val navigateToCartUseCase: NavigateToCartUseCase
) : ViewModel() {
    private val mutableBasketSizeState: MutableLiveData<BasketSizeState> = MutableLiveData()
    val basketSizeState: LiveData<BasketSizeState>
        get() {
            if (mutableBasketSizeState.value != null) {
                return mutableBasketSizeState
            }
            return mutableBasketSizeState.apply {
                mutableBasketSizeState.value = BasketSizeState.Loading
                viewModelScope.launch(Dispatchers.IO + basketExceptionHandler) {
                    mutableBasketSizeState.postValue(
                        BasketSizeState.Success(getItemsInCartNumberUseCase())
                    )
                }
            }
        }

    private val basketExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableBasketSizeState.postValue(BasketSizeState.Error(throwable))
    }

    fun replaceWithExplorer() = replaceWithExplorerUseCase()

    fun navigateToCart() = navigateToCartUseCase()
}