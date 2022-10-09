package com.compose.quran.ui.surah

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.quran.R
import com.compose.quran.ui.theme.GreenPrimary
import com.compose.quran.ui.theme.MobileQuranTheme
import com.compose.quran.ui.theme.SoftGrey
import com.compose.quran.ui.widget.IndexAyah
import com.compose.quran.ui.widget.TextWidget

@Composable
fun SurahCard(
    surahName : String
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 34.dp)
    ) {
        val (image, title, description, ayah, divider) = createRefs()
        IndexAyah(
            R.drawable.ic_ayah_frame,
            Modifier
                .width(40.dp)
                .height(40.dp)
                .constrainAs(image) {
                    centerVerticallyTo(parent)
                    top.linkTo(parent.top)
                },
            "12"
        )
        Text(
            text = surahName,
            fontWeight = FontWeight.Bold,
            color = GreenPrimary,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 15.dp)
                .constrainAs(title) {
                    top.linkTo(image.top)
                    bottom.linkTo(description.top)
                    start.linkTo(image.end)
                }

        )

        TextWidget(
            text = "MEKAH - 7 AYAT",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 15.dp)
                .constrainAs(description) {
                    top.linkTo(title.bottom)
                    bottom.linkTo(image.bottom)
                    start.linkTo(image.end)
                }
        )
        Text(
            text = "الفاتحة",
            fontWeight = FontWeight.Bold,
            color = GreenPrimary,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 15.dp)
                .constrainAs(ayah) {
                    centerVerticallyTo(parent)
                    end.linkTo(parent.end)
                },
        )
        Divider(
            color = SoftGrey, thickness = 1.dp,
            modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(description.bottom)
                }
                .padding(top = 18.dp)
        )
    }
}

@Preview
@Composable
fun SurahCardPreview() {
    MobileQuranTheme(darkTheme = false) {
        SurahCard("Alfatihah")
    }
}
