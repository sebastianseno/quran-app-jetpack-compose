package com.compose.quran.ui.surahDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.quran.R

@Composable
fun SurahDetail() {

}

@Preview
@Composable
fun HeaderSurahDetail() {
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tilawah",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Ar Rahman Ayat 15",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}