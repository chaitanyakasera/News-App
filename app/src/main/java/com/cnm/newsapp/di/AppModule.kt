package com.cnm.newsapp.di

import com.cnm.newsapp.data.api.ApiService
import com.cnm.newsapp.data.api.BASE_URL
import com.cnm.newsapp.data.datasource.INewsDataSource
import com.cnm.newsapp.data.datasource.NewsDataSourceImpl
import com.cnm.newsapp.ui.repository.NewsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(loggingInterceptor)
            readTimeout(60, TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesNewDataSource(apiService: ApiService): INewsDataSource {
        return NewsDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(dataSource: INewsDataSource): NewsRepository {
        return NewsRepository(dataSource)
    }

}