package com.cnm.newsapp.data.datasource

import com.cnm.newsapp.data.entity.RmTopHeadlines
import retrofit2.Response

interface INewsDataSource {
    suspend fun getTopHeadlines(country: String): Response<RmTopHeadlines>

}