package com.compose.quran.ui.surah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.compose.foundation.lazy.LazyColumn
import com.compose.quran.rest.response.UnsplashImage
import com.compose.quran.ui.surah.viewModel.SurahViewModel
import com.compose.quran.ui.theme.GreenPrimary

@Composable
fun SurahList(
    viewModel: SurahViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val githubUsers: LazyPagingItems<UnsplashImage> = viewModel.userGithub.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 15.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = githubUsers,
        ) { item ->
            item.let {
                SurahCard(
                    surahName = it?.id.orEmpty(),
                    arab = "",
                    number = 1,
                    totalAyah = 0,
                    revelationPlace = it?.likes.toString().orEmpty(),
                    onItemClick = {

                    }
                )
            }
        }
        when (githubUsers.loadState.append) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {
                    CircularProgressIndicator(
                        color = GreenPrimary,

                        )
                }
            }
            is LoadState.Error -> {
                item {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                }
            }
        }


    }
}