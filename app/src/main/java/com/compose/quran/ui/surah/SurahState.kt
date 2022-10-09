package com.compose.quran.ui.surah

import com.compose.quran.rest.response.SurahListResponseItem

data class SurahState(
    val isLoading: Boolean = false,
    val surah: List<SurahListResponseItem>? = null,
    val error: String = ""
)
