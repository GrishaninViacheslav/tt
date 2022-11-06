package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.grishaninvyacheslav.core_ui.presnetation.BaseViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.cart.ICartRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val cartRepository: ICartRepository,
) : BaseViewModel() {
    private val mutableBasketSizeState: MutableLiveData<BasketSizeState> = MutableLiveData()
    val basketSizeState: LiveData<BasketSizeState>
        get() {
            if (mutableBasketSizeState.value != null) {
                return mutableBasketSizeState
            }
            return mutableBasketSizeState.apply {
                mutableBasketSizeState.value = BasketSizeState.Loading
                CoroutineScope(Dispatchers.IO + basketExceptionHandler).launch {
                    mutableBasketSizeState.postValue(
                        BasketSizeState.Success(cartRepository.getCart()?.basket?.size ?: 0)
                    )
                }.also { cancelableJobs.add(it) }
            }
        }

    private val basketExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableBasketSizeState.postValue(BasketSizeState.Error(throwable))
    }
}