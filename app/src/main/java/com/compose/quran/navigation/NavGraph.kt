package com.compose.quran.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
@ExperimentalPagerApi
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SurahListScreen.route
    ) {
        surahNavGraph(navController)
    }
}