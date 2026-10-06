package com.mob.xtravuwatchdog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.mob.xtravuwatchdog.model.AppDetails
import com.mob.xtravuwatchdog.repository.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppDetailsViewModel(val repository: AppDetailsRepository) : ViewModel() {
    private val _appDetails = MutableLiveData<List<AppDetails>>()
    val appDetails: LiveData<List<AppDetails>> get() = _appDetails


    // Insert app details
    fun insertAppDetails(appDetails: AppDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAppDetails(appDetails)
        }
    }
    fun getAppDetails(){
        viewModelScope.launch(Dispatchers.IO){
            val appdetails=repository.getAppDetails()
            println("logList:::"+ Gson().toJson(appdetails))
            _appDetails.postValue(appdetails)

        }

    }
}