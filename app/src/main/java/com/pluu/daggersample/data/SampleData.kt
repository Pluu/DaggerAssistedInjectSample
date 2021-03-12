package com.pluu.daggersample.data

import javax.inject.Inject

class SampleData @Inject constructor() {
    fun getList() = (0..10).toList()
}