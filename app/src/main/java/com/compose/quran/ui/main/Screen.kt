package com.compose.quran.ui.main

sealed class Screen(val route: String) {
    object SurahListScreen: Screen("surah_list_screen")
    object SurahDetailScreen: Screen("surah_detail_screen")
}
