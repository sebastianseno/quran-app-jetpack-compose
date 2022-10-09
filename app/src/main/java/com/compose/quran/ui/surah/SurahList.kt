package com.compose.quran.ui.surah

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.quran.ui.surah.viewModel.SurahViewModel
import java.util.*

@Composable
fun SurahList(
    viewModel: SurahViewModel = hiltViewModel()
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
                    }
                )
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

data class Surah(
    val ayah: Int,
    val name: String,
    val arab: Int,
    val symbol: String,
)
