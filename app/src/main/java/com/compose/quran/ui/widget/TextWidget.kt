package com.compose.quran.ui.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.compose.quran.ui.theme.GreenPrimary
import com.compose.quran.ui.theme.PoppinsFontFamily

@Composable
fun TextWidget(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 13.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = GreenPrimary,
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontFamily = PoppinsFontFamily,
        color = color,
        fontSize = fontSize,
        modifier = modifier
    )
}