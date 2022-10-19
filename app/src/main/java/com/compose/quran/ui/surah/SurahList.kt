package com.compose.quran.ui.surah

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.quran.ui.main.Screen
import com.compose.quran.ui.surah.viewModel.SurahViewModel
import com.compose.quran.ui.theme.GreenPrimary

@Composable
fun SurahList(
    viewModel: SurahViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.surah.orEmpty()) { surah ->
                SurahCard(
                    surahName = surah.latinName,
                    arab = surah.name,
                    number = surah.number,
                    totalAyah = surah.numberOfVerses,
                    revelationPlace = surah.revelationPlace.replaceFirstChar {
                        it.uppercase()
                    },
                    onItemClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set<String>(
                            "SURAH", surah.latinName
                        )
                        navController.navigate(Screen.SurahDetailScreen.route)
                    }
                )
            }
        }
        if (state.error.isNotBlank() || state.surah.isNullOrEmpty()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                color = GreenPrimary,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}