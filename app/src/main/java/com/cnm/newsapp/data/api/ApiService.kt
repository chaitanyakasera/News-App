package com.cnm.newsapp.data.api

import com.cnm.newsapp.IgnoredFile
import com.cnm.newsapp.data.entity.RmTopHeadlines
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("apiKey")
        apiKey: String = IgnoredFile.API_KEY
    ): Response<RmTopHeadlines>


}