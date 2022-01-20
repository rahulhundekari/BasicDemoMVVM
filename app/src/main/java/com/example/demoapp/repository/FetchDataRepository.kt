package com.example.demoapp.repository

import com.example.demoapp.network.ApiResponse
import com.example.demoapp.network.ApiService
import com.example.demoapp.utils.BaseApiResponse
import com.example.demoapp.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


@ActivityRetainedScoped
class FetchDataRepository @Inject constructor(
    private val apiService: ApiService
) : BaseApiResponse() {

    var client = OkHttpClient()

    suspend fun fetchApiResponse(url: String): Flow<NetworkResult<ApiResponse>> {
        return flow {
            emit(safeApiCall { apiService.call(url) })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun callApiService(url: String): Flow<String> {
        return flow {
            @Suppress("BlockingMethodInNonBlockingContext")
            emit( run(url))
        }.flowOn(Dispatchers.IO)
    }


    @Throws(IOException::class)
    fun run(url: String): String {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute()
            .use { response ->
                return response.body!!.
                string() }
    }
}