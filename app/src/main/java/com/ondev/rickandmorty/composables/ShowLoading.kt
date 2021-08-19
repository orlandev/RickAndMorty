package com.ondev.rickandmorty.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowLoading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RickText(text = "Loading...", 14.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
            color = Color.Red)
    }
}