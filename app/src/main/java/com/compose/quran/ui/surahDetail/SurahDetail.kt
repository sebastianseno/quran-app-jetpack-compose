package com.compose.quran.ui.surahDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.quran.R
import com.compose.quran.ui.surahDetail.viewModel.SurahDetailViewModel
import com.compose.quran.ui.theme.BackGround
import com.compose.quran.ui.theme.GreenPrimary
import com.compose.quran.ui.widget.TextWidget

@Preview
@Composable
fun SurahDetail(
    viewModel: SurahDetailViewModel = hiltViewModel(),
    name: String = "1"
) {
    val state = viewModel.state.value
    Column(
        Modifier
            .background(MaterialTheme.colors.background)
            .padding(
                vertical = 24.dp
            )
    ) {
        HeaderSurahDetail(
            name,
            state.surah?.arti.orEmpty(),
            state.isLoading
        )
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                state.surah?.ayat?.let {
                    items(it) { surah ->
                        SurahDetailCard(
                            ayah = surah.nomor.toString(),
                            arab = surah.ar,
                            idn = surah.idn
                        )
                    }
                }
            }
            if (state.error.isNotBlank() || state.surah?.ayat.isNullOrEmpty()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = GreenPrimary,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun HeaderSurahDetail(
    name: String,
    meaning: String,
    isLoading: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(98.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.bg_header_detail_surah),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        if (isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextWidget(
                    text = name,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                TextWidget(
                    text = meaning,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}