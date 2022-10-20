package com.compose.quran.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.quran.navigation.SetupNavGraph
import com.compose.quran.ui.surahDetail.SurahDetail
import com.compose.quran.ui.theme.MobileQuranTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileQuranTheme {
                Scaffold() {
                    val navController = rememberNavController()
                    SetupNavGraph(navController)
                }
            }
        }
    }
}