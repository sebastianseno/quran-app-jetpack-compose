package com.compose.quran.ui.prayerTime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.quran.R
import com.compose.quran.ui.theme.GreenPrimary
import com.compose.quran.ui.widget.TextWidget

@Preview
@Composable
fun PrayerCard() {
    Row(

        Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp, start = 30.dp, end = 30.dp, top = 12.dp)

    ) {
        TextWidget(
            text = "Imsak",
            fontSize = 16.sp,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier
                .width(0.dp)
                .weight(1f)
        )

        TextWidget(
            text = "04:33",
            fontSize = 13.sp,
            color = GreenPrimary,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            painter = painterResource(R.drawable.ic_noun_adzan),
            contentDescription = null,
            modifier = Modifier
                .width(21.dp)
                .height(21.dp)
        )
    }
}