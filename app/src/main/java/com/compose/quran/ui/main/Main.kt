package com.compose.quran.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.quran.ui.surah.Header
import com.compose.quran.ui.surah.SurahList
import com.compose.quran.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun Main(
    navController: NavController
) {
    Column (Modifier.background(MaterialTheme.colors.background)){
        Header()
        TabLayout(navController)
    }
}

@ExperimentalPagerApi
@Composable
fun TabLayout(navController: NavController) {
    val page = listOf(
        "Surah",
        "Juz",
        "Do’a",
        "Dzikir",
    )
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        indicator = {
            TabRowDefaults.Indicator(
                Modifier
                    .pagerTabIndicatorOffset(pagerState, it),
                height = 2.dp,
                color = GreenPrimary,
            )
        },
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        page.forEachIndexed { index, string ->
            Tab(
                selectedContentColor = GreenPrimary,
                unselectedContentColor = UnselectedGrey,
                text = {
                    Text(
                        text = string,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
    TabsContent(navController, page, pagerState)
}

@Composable
@ExperimentalPagerApi
fun TabsContent(
    navController: NavController,
    pageList: List<String>,
    pagerState: PagerState
) {
    HorizontalPager(
        count = pageList.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxHeight()
    ) { page ->
        when (page) {
            0 -> {
                SurahList(navController = navController)
            }
            1 -> {
                SurahList(navController = navController)
            }
            else -> {
                SurahList(navController = navController)
            }
        }
    }
}