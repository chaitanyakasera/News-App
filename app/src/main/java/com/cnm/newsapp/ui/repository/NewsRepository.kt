package com.cnm.newsapp.ui.repository

import com.cnm.newsapp.data.datasource.INewsDataSource
import com.cnm.newsapp.data.entity.RmTopHeadlines
import com.cnm.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: INewsDataSource) {

    //    suspend fun getTopHeadlines(country: String): Response<RmTopHeadlines> {
//        return newsDataSource.getTopHeadlines(country)
//    }
    suspend fun getTopHeadlines(country: String): Flow<ResourceState<RmTopHeadlines>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getTopHeadlines(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error Fetching News"))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage ?: "Error In Flow"))
        }
    }


}