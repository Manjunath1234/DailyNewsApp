package com.example.dailynewsapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dailynewsapp.R
import com.example.dailynewsapp.domain.model.Article
import com.example.dailynewsapp.presentation.MyApp
import com.example.dailynewsapp.ui.theme.DailyNewsAppTheme


@Composable
fun HomeScreen (viewModel: NewsViewModel = hiltViewModel()){
    val res = viewModel.articles.value

    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()){
        Text(text = res.error, textAlign = TextAlign.Center)
    }

    res.data?.let {
        LazyColumn {
            items(it){
                ArticleItem(it)
            }
        }
    }
}

@Composable
fun ArticleItem(it: Article) {

    Column(modifier = Modifier){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(it.urlToImage)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.image_holder),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),


            )
        Text(
            text = it.author, style = androidx.compose.ui.text.TextStyle(color = Color.Gray,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            ),
            modifier = Modifier.padding(12.dp).alpha(if(it.author.isNotBlank()) 1f else 0f)
        )
        Text(
            text = it.title, style = androidx.compose.ui.text.TextStyle(color = Color.Gray,
                fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            ),
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = it.description, style = androidx.compose.ui.text.TextStyle(color = Color.Gray,
                fontWeight = FontWeight.Medium, fontSize = 18.sp
            ),
            modifier = Modifier.padding(12.dp)
        )
        Spacer(modifier=Modifier.height(12.dp))
    }

}
