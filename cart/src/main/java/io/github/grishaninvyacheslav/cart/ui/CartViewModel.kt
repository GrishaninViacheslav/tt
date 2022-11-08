package io.github.grishaninvyacheslav.cart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.github.grishaninvyacheslav.cart.data.ICartRepository
import io.github.grishaninvyacheslav.core_ui.ui.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
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
                viewModelScope.launch(Dispatchers.IO + cartExceptionHandler){
                    mutableCartState.postValue(
                        CartState.Success(cartRepository.getCart())
                    )
                }
            }
        }

    private val cartExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableCartState.postValue(CartState.Error(throwable))
    }
}