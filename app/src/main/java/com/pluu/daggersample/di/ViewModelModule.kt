package com.pluu.daggersample.di

import androidx.lifecycle.ViewModel
import com.pluu.daggersample.SampleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    abstract fun bindSampleViewModel(factory: SampleViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}