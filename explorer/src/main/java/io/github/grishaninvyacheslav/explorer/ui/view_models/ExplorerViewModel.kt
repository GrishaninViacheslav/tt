package io.github.grishaninvyacheslav.explorer.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.grishaninvyacheslav.core_ui.ui.BaseViewModel
import io.github.grishaninvyacheslav.explorer.domain.use_cases.filter_categories.FilterCategoriesUseCase
import io.github.grishaninvyacheslav.explorer.data.IExplorerRepository
import io.github.grishaninvyacheslav.explorer.ui.view_models.states.BestSellersState
import io.github.grishaninvyacheslav.explorer.ui.view_models.states.CategoriesState
import io.github.grishaninvyacheslav.explorer.ui.view_models.states.HotSalesState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExplorerViewModel(
    private val filterCategoriesUseCase: FilterCategoriesUseCase,
    private val explorerRepository: IExplorerRepository
) : BaseViewModel() {
    private val mutableCategoriesState: MutableLiveData<CategoriesState> = MutableLiveData()
    val categoriesState: LiveData<CategoriesState>
        get() {
            if (mutableCategoriesState.value != null) {
                return mutableCategoriesState
            }
            return mutableCategoriesState.apply {
                mutableCategoriesState.value = CategoriesState.Loading
                CoroutineScope(Dispatchers.IO + categoriesExceptionHandler).launch {
                    mutableCategoriesState.postValue(
                        CategoriesState.Success(filterCategoriesUseCase.getCategories())
                    )
                }.also { cancelableJobs.add(it) }
            }
        }

    private val mutableHotSalesState: MutableLiveData<HotSalesState> = MutableLiveData()
    val hotSalesState: LiveData<HotSalesState>
        get() {
            if (mutableHotSalesState.value != null) {
                return mutableHotSalesState
            }
            return mutableHotSalesState.apply {
                mutableHotSalesState.value = HotSalesState.Loading
                CoroutineScope(Dispatchers.IO + hotSalesExceptionHandler).launch {
                    mutableHotSalesState.postValue(
                        HotSalesState.Success(explorerRepository.getHotSales())
                    )
                }.also { cancelableJobs.add(it) }
            }
        }

    private val mutableBestSellersState: MutableLiveData<BestSellersState> = MutableLiveData()
    val bestSellersState: LiveData<BestSellersState>
        get() {
            if (mutableBestSellersState.value != null) {
                return mutableBestSellersState
            }
            return mutableBestSellersState.apply {
                mutableBestSellersState.value = BestSellersState.Loading
                CoroutineScope(Dispatchers.IO + bestSellersExceptionHandler).launch {
                    mutableBestSellersState.postValue(
                        BestSellersState.Success(explorerRepository.getBestSellers())
                    )
                }.also { cancelableJobs.add(it) }
            }
        }

    fun selectCategory(selectedCategoryIndex: Int) {
        if (mutableCategoriesState.value == CategoriesState.Loading) {
            return
        }
        mutableCategoriesState.value = CategoriesState.Loading
        CoroutineScope(Dispatchers.IO + categoriesExceptionHandler).launch {
            mutableCategoriesState.postValue(
                CategoriesState.Success(
                    filterCategoriesUseCase.selectCategory(
                        selectedCategoryIndex
                    )
                )
            )
        }.also { cancelableJobs.add(it) }
    }

    private val categoriesExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableCategoriesState.postValue(CategoriesState.Error(throwable))
    }

    private val hotSalesExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableHotSalesState.postValue(HotSalesState.Error(throwable))
    }

    private val bestSellersExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        mutableCategoriesState.postValue(CategoriesState.Error(throwable))
    }
}