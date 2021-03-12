package com.pluu.daggersample

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pluu.daggersample.data.SampleData
import com.pluu.daggersample.di.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import timber.log.Timber

class SampleViewModel @AssistedInject constructor(
    private val application: Application,
    private val sampleData: SampleData,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val filteredData: LiveData<String> = savedStateHandle.getLiveData("query")

    init {
        Timber.d("Application = ${application.hashCode()}")
        Timber.d("SampleData = ${sampleData.hashCode()}")
    }

    fun setQuery(query: String) {
        savedStateHandle["query"] = query
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<SampleViewModel>
}
