package com.compose.quran.ui.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.quran.R

@Composable
fun IndexAyah(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 13.sp,
    @DrawableRes backgroundDrawableResId: Int = R.drawable.ic_ayah_frame,
    textNumber: String = ""
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(backgroundDrawableResId),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
        )
        TextWidget(
            text = textNumber,
            fontSize = fontSize,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 3.dp)
        )
    }
}