package com.mob.xtravuwatchdog.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mob.xtravuwatchdog.viewmodel.AppDetailsViewModel

class AppDetailViewModelFactory (private val repository: AppDetailsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppDetailsViewModel::class.java)) {
            return AppDetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}