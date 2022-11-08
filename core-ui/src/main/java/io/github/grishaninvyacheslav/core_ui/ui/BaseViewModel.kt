package io.github.grishaninvyacheslav.core_ui.ui

import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.core_ui.utils.CancelableJobs

abstract class BaseViewModel: ViewModel() {
    override fun onCleared() {
        super.onCleared()
        cancelableJobs.cancel()
    }

    protected open val cancelableJobs: CancelableJobs = CancelableJobs()
}