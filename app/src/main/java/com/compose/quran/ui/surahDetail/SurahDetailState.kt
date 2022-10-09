package com.compose.quran.ui.surahDetail

import com.compose.quran.rest.response.DetailSurahResponse
import com.compose.quran.rest.response.SurahListResponseItem

data class SurahDetailState(
    val isLoading: Boolean = false,
    val surah: DetailSurahResponse? = null,
    val error: String = ""
)
