package com.compose.quran.ui.surahDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.quran.R
import com.compose.quran.ui.theme.BackGround
import com.compose.quran.ui.theme.GreenSolid2
import com.compose.quran.ui.theme.SoftGrey
import com.compose.quran.ui.widget.TextWidget

@Preview
@Composable
fun SurahDetailCard() {
    Column(
        Modifier
            .background(BackGround)
            .padding(horizontal = 24.dp, vertical = 14.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = GreenSolid2,
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 13.dp)
            ) {
                TextWidget(text = "1")
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(
                        R.drawable.ic_play,
                    ), contentDescription = "Play"
                )
            }
        }
        TextWidget(
            text = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ",
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.End)
        )
        TextWidget(
            text = "Dengan nama Allah Yang Maha Pengasih lagi Maha Penyayang.",
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
        )
        Divider(
            color = SoftGrey, thickness = 1.dp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}