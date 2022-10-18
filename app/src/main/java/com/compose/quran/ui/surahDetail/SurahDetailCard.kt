package com.compose.quran.ui.surahDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.quran.R
import com.compose.quran.ui.theme.GreenPrimary
import com.compose.quran.ui.theme.GreenSolid2
import com.compose.quran.ui.theme.NoorHidayatFamily
import com.compose.quran.ui.theme.SoftGrey
import com.compose.quran.ui.widget.IndexAyah
import com.compose.quran.ui.widget.TextWidget

@Composable
fun SurahDetailCard(
    ayah: String,
    arab: String,
    idn: String,
) {
    Column(
        Modifier
            .background(MaterialTheme.colors.background)
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
                IndexAyah(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp),
                    fontSize = 10.sp,
                    backgroundDrawableResId = R.drawable.ic_ayah_frame,
                    textNumber = ayah
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(
                        R.drawable.ic_play,
                    ), contentDescription = "Play"
                )
            }
        }
        Text(
            text = arab,
            fontSize = 24.sp,
            textAlign = TextAlign.End,
            color = GreenPrimary,
            fontFamily = NoorHidayatFamily,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .align(Alignment.End)

        )
        TextWidget(
            text = idn,
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