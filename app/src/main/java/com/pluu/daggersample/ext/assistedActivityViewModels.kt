package com.pluu.daggersample.ext

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.pluu.daggersample.di.InjectingSavedStateViewModelFactory

inline fun <reified T : ViewModel> ComponentActivity.assistedViewModels(
    crossinline factory: () -> InjectingSavedStateViewModelFactory
): Lazy<T> {
    return viewModels {
        factory().create(this, intent.extras)
    }
}