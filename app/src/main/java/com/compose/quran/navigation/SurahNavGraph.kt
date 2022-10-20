package com.compose.quran.navigation

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.compose.quran.common.Constants.PARAM_SURAH
import com.compose.quran.common.Constants.SURAH_SCREEN_GRAPH_ROUTE
import com.compose.quran.ui.main.Main
import com.compose.quran.ui.surahDetail.SurahDetail
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
fun NavGraphBuilder.surahNavGraph(
    navController: NavHostController
) {
    composable(
        route = Screen.SurahListScreen.route
    ) {
        Main(navController)
    }
    composable(
        route = Screen.SurahDetailScreen.route,
        arguments = listOf(
            navArgument(PARAM_SURAH) {
                type = NavType.StringType
            }
        )
    ) {
        val surahName =it.arguments?.getString(PARAM_SURAH) ?: ""
        SurahDetail(name = surahName)
    }
}