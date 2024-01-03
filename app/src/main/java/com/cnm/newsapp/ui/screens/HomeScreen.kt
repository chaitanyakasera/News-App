package com.cnm.newsapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cnm.newsapp.ui.composable.EmptySpaceComposable
import com.cnm.newsapp.ui.composable.Loader
import com.cnm.newsapp.ui.composable.NewsRowComponent
import com.cnm.newsapp.ui.viewmodel.NewsViewModel
import com.cnm.newsapp.utils.makeLogD
import com.cnm.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    val newsResponse by newsViewModel.news.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(
        state =
        pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page ->
        when (newsResponse) {
            is ResourceState.Loading -> {
                Loader()
                makeLogD("loading")
            }

            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                if (response.articles.isNotEmpty()) {
//                    EmptySpaceComposable()
                    NewsRowComponent(page, response.articles[page])
                } else {                                  
                    EmptySpaceComposable()
                }
            }

            is ResourceState.Error -> {
                val error = newsResponse as ResourceState.Error
                makeLogD("error" + error)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}