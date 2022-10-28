package com.compose.quran.ui.surah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.compose.quran.rest.response.Item
import com.compose.quran.ui.surah.viewModel.SurahViewModel
import com.compose.quran.ui.theme.GreenPrimary

@Composable
fun SurahList(
    viewModel: SurahViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val githubUsers: LazyPagingItems<Item> = viewModel.userGithub.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 15.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = githubUsers.itemSnapshotList,
            key = {
                it?.id ?: 0
            }
        ) { item ->
            item.let {
                SurahCard(
                    surahName = it?.login.orEmpty(),
                    arab = "",
                    number = 1,
                    totalAyah = 0,
                    revelationPlace = it?.fullName.orEmpty(),
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

//            items(state.surah.orEmpty()) { surah ->
//                SurahCard(
//                    surahName = surah.latinName,
//                    arab = surah.name,
//                    number = surah.number,
//                    totalAyah = surah.numberOfVerses,
//                    revelationPlace = surah.revelationPlace.replaceFirstChar {
//                        it.uppercase()
//                    },
//                    onItemClick = {
//                        navController.navigate(Screen.SurahDetailScreen.route + "/${surah.number}")
//                    }
//                )
//            }
    }
}