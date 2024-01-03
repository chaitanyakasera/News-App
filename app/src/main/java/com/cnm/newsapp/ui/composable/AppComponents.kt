package com.cnm.newsapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cnm.newsapp.R
import com.cnm.newsapp.data.entity.RmTopHeadlines
import com.cnm.newsapp.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun TopHeadlineList(
    newsResponse: RmTopHeadlines
) {
    LazyColumn(content = {
        items(newsResponse.articles) {
            HeadingTextComponent(textValue = it.title ?: "NA")
        }
    })
}

@Composable
fun NewsRowComponent(
    page: Int, article: RmTopHeadlines.Article
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            model = article.urlToImage, contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Spacer(modifier = Modifier.height(20.dp))
        HeadingTextComponent(textValue = article.title ?: "")
        Spacer(modifier = Modifier.height(10.dp))
        NormalTextComponent(textValue = article.description ?: "")
        Spacer(modifier = Modifier.height(10.dp))
        AuthorDetailComponent(article.author, article.source?.name)
    }
}


@Composable
fun HeadingTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif
        )
    )
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif
        )
    )
}

@Composable
fun AuthorDetailComponent(authorName: String?, source: String?) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        authorName?.also {
            Text(text = it)
        }
        Spacer(modifier = Modifier.weight(1f))
        source?.also {
            Text(text = it)
        }

    }
}

@Composable
fun EmptySpaceComposable() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )
        Text(text = "No news for now Try again Later", textAlign = TextAlign.Center)
    }
}