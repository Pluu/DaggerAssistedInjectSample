package com.pluu.daggersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.daggersample.databinding.ActivityMainBinding
import com.pluu.daggersample.di.InjectingSavedStateViewModelFactory
import com.pluu.daggersample.ext.assistedViewModels
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var abstractViewModelFactory: InjectingSavedStateViewModelFactory
    private val viewModel: SampleViewModel by assistedViewModels {
        abstractViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLabel.text = viewModel.toString()

        binding.btnSet.setOnClickListener {
            viewModel.setQuery((0..1_000_000).random().toString())
        }
        viewModel.filteredData.observe(this) {
            binding.tvLabel2.text = it
        }
    }
}