package com.pluu.daggersample.di

import com.pluu.daggersample.data.SampleData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {
    @Singleton
    @Provides
    fun provideSampleData(): SampleData = SampleData()
}
