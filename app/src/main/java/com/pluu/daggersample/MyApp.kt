package com.pluu.daggersample

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.pluu.daggersample.di.AppComponent
import com.pluu.daggersample.di.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())

        Timber.d("Application = ${hashCode()}")

        appComponent = DaggerAppComponent
            .factory()
            .create(this)
    }
}

val Activity.appComponent get() = (application as MyApp).appComponent
val Fragment.appComponent get() = (requireActivity().application as MyApp).appComponent
