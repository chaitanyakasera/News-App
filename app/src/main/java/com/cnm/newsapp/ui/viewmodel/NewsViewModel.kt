package com.cnm.newsapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cnm.newsapp.data.entity.RmTopHeadlines
import com.cnm.newsapp.ui.repository.NewsRepository
import com.cnm.newsapp.utils.makeLogD
import com.cnm.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepositroy: NewsRepository
) : ViewModel() {
    companion object {
        val TAG = this::class.java.simpleName
    }

    private val _news: MutableStateFlow<ResourceState<RmTopHeadlines>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<RmTopHeadlines>> = _news

    init {
        getNews("us")
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepositroy.getTopHeadlines(country)
                .collectLatest { news ->
                    _news.value = news
                }
        }
    }


}