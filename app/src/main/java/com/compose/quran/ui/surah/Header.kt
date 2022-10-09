package com.compose.quran.ui.surah

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.quran.R
import com.compose.quran.ui.theme.DarkHard
import com.compose.quran.ui.theme.Shapes

@Preview
@Composable
fun Header() {
    Column(
        modifier = Modifier
            .padding(
                horizontal = 24.dp,
                vertical = 24.dp
            )
    ) {
        Text(
            text = "Assalamu’alaikum",
            fontSize = 15.sp,
            color = DarkHard,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Reza Al Farel",
            fontSize = 32.sp,
            color = DarkHard,
            fontWeight = FontWeight.SemiBold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.bg_header_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            ConstraintLayout(
                modifier = Modifier
                    .padding(start = 24.dp, top = 38.dp)
            ) {
                val (icon, lastRead, tilawah, content) = createRefs()
                Image(
                    painter = painterResource(R.drawable.ic_open_quran),
                    contentDescription = "image",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .constrainAs(icon) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                )
                Text(
                    text = "Last Read",
                    fontSize = 13.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 9.dp, top = 3.dp)
                        .constrainAs(lastRead) {
                            top.linkTo(icon.top)
                            bottom.linkTo(icon.bottom)
                            start.linkTo(icon.end)
                        }
                )
                Text(
                    text = "Tilawah",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .constrainAs(tilawah) {
                            top.linkTo(lastRead.bottom)
                            start.linkTo(icon.start)
                        }
                )
                Text(
                    text = "Ar Rahman Ayat 15",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(content) {
                            top.linkTo(tilawah.bottom)
                            start.linkTo(tilawah.start)
                        }
                )
            }
        }
    }
}