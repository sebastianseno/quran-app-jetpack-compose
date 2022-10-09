package com.compose.quran.ui.surah

import com.compose.quran.rest.response.SurahListResponse

data class SurahState(
    val isLoading: Boolean = false,
    val surah: SurahListResponse? = null,
    val error: String = ""
)
