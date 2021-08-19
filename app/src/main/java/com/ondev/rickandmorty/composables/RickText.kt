package com.ondev.rickandmorty.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun RickText(
    text: String,
    textSize: TextUnit = 14.sp,
    textColor: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        text = text,
        fontSize = textSize,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        fontWeight = fontWeight,
        color = textColor,
        fontFamily = FontFamily.Default
    )
}