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
class ListViewModel @Inject constructor(
    private val fetchDataRepository: FetchDataRepository
) : ViewModel() {

    private val _response: MutableLiveData<NetworkResult<ApiResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<ApiResponse>> = _response

//    init {
//        fetchApiResponse("http://phorus.vtuner.com/setupapp/phorus/asp/browsexml/navXML.asp?gofile=LocationLevelFourCityUS-North%20America-New%20York-ExtraDir-1-Inner-14&bkLvl=9237&mac=a8f58cd9758b710c43a7a63762e755947f83f0ad9194aa294bbaee55e0509e02&dlang=eng&fver=1.4.4.2299%20(20150604)&hw=CAP:%201.4.0.075%20MCU:%201.032%20BT:%200.002")
//    }

    fun fetchApiResponse(url: String) {
        _response.value = NetworkResult.Loading()
        viewModelScope.launch {
            fetchDataRepository.fetchApiResponse(url)
                .collect {
                    _response.value = it
                }
        }

    }


}