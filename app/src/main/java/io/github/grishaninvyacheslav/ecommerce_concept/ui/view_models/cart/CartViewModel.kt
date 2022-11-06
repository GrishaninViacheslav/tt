package io.github.grishaninvyacheslav.ecommerce_concept.ui.view_models.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.grishaninvyacheslav.core_ui.presnetation.BaseViewModel
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.repository.cart.ICartRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val cartRepository: ICartRepository
) : BaseViewModel() {
    private val mutableCartState: MutableLiveData<CartState> = MutableLiveData()
    val cartState: LiveData<CartState>
        get() {
            if (mutableCartState.value != null) {
                return mutableCartState
            }
            return mutableCartState.apply {
                mutableCartState.value = CartState.Loading
                CoroutineScope(Dispatchers.IO + cartExceptionHandler).launch {
                    mutableCartState.postValue(
                        CartState.Success(cartRepository.getCart())
                    )
                }.also { cancelableJobs.add(it) }
            }
        }

    private val cartExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableCartState.postValue(CartState.Error(throwable))
    }
}