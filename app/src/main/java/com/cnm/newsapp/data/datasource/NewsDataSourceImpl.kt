package com.cnm.newsapp.data.datasource

import com.cnm.newsapp.data.api.ApiService
import com.cnm.newsapp.data.entity.RmTopHeadlines
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : INewsDataSource {
    override suspend fun getTopHeadlines(country: String): Response<RmTopHeadlines> {
        return apiService.getTopHeadlines(country)
    }

}