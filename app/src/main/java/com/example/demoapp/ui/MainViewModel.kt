package com.example.demoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.network.ApiResponse
import com.example.demoapp.repository.FetchDataRepository
import com.example.demoapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchDataRepository: FetchDataRepository
) : ViewModel() {

    private val _response: MutableLiveData<NetworkResult<ApiResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<ApiResponse>> = _response

    fun fetchApi(url: String) {
        viewModelScope.launch {
            fetchDataRepository.callApiService(url)
                .collect {
                    val data = it
                }
        }

    }

}