package com.compose.quran.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.quran.ui.prayerTime.PrayerCard
import com.compose.quran.ui.prayerTime.PrayerTimeScreen
import com.compose.quran.ui.surah.SurahList
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SurahList()
                }
            }
        }
    }
}