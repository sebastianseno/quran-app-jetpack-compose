package com.compose.quran.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.compose.quran.common.Constants.SURAH_SCREEN_GRAPH_ROUTE
import com.compose.quran.ui.surahDetail.SurahDetail
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
fun NavGraphBuilder.detailSurahNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.SurahDetailScreen.route,
        route = SURAH_SCREEN_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.SurahDetailScreen.route
        ) {
            SurahDetail()
        }
    }
}