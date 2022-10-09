package com.compose.quran.ui.surah

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.quran.ui.surah.viewModel.SurahViewModel

@Composable
fun SurahList(
    viewModel: SurahViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.surah.orEmpty()) { surah ->
                SurahCard(surahName = surah.name)
            }
        }
}

data class Surah(
    val ayah: Int,
    val name: String,
    val arab: Int,
    val symbol: String,
)
