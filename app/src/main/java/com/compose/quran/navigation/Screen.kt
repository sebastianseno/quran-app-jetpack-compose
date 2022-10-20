package com.compose.quran.navigation

import com.compose.quran.common.Constants.PARAM_SURAH

sealed class Screen(val route: String) {
    object SurahListScreen: Screen("surah_list_screen")
    object SurahDetailScreen: Screen("surah_detail_screen?surahName={$PARAM_SURAH}") {
        fun passSurahId(
            id: String = "",
        ): String {
            return "surah_detail_screen?surahName=$id"
        }
    }
}
