package io.github.grishaninvyacheslav.cart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.grishaninvyacheslav.cart.domain.use_cases.get_cart.GetCartUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val getCartUseCase: GetCartUseCase
) : ViewModel() {
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
                        CartState.Success(getCartUseCase())
                    )
                }
            }
        }

    private val cartExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableCartState.postValue(CartState.Error(throwable))
    }
}