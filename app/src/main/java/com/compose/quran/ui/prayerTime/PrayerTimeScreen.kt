package com.compose.quran.ui.prayerTime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.quran.R
import com.compose.quran.ui.theme.BackGround
import com.compose.quran.ui.theme.GreenPrimary
import com.compose.quran.ui.theme.GreenSolid2
import com.compose.quran.ui.widget.TextWidget

@Preview
@Composable
fun PrayerTimeScreen() {
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                GreenPrimary
            )
    ) {
        val (header, time, prayerSchedule) = createRefs()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(header) {
                    top.linkTo(parent.top)
                }
                .background(GreenPrimary)
        ) {
            TextWidget(
                text = "Cluster Cibogo Asri No.7\nCimahi Selatan, Kota Cimahi, Jawa Barat",
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 24.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(52.dp))
            Image(
                painter = painterResource(R.drawable.img_sun),
                contentDescription = null,
                modifier = Modifier
                    .width(327.dp)
                    .height(90.dp)
            )
        }
        Column(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 18.dp,
                        topEnd = 18.dp
                    )
                )
                .fillMaxSize()
                .fillMaxWidth()
                .background(
                    BackGround
                )
                .constrainAs(prayerSchedule) {
                    top.linkTo(header.bottom)
                }
        ) {
            Spacer(
                modifier = Modifier
                    .height(61.dp)
            )
            Column(
                Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 32.dp
                    )
                    .clip(
                        RoundedCornerShape(18.dp)
                    )
                    .background(GreenSolid2)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(31.dp)
                )
                PrayerCard()
                PrayerCard()
                PrayerCard()
                PrayerCard()
                PrayerCard()
                Spacer(
                    modifier = Modifier
                        .height(31.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .width(327.dp)
                .height(70.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(GreenSolid2)
                .constrainAs(time) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(header.bottom)
                    end.linkTo(parent.end)
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextWidget(
                text = "Jum’at, 15 Juli 2022",
                fontSize = 16.sp,
                color = GreenPrimary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            TextWidget(
                text = "15 DzulHijjah 1443 H",
                fontSize = 12.sp,
                color = GreenPrimary,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}
