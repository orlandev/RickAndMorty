package com.ondev.rickandmorty.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ondev.rickandmorty.R
import com.ondev.rickandmorty.data.Character
import com.ondev.rickandmorty.ui.theme.aDeadRed
import com.ondev.rickandmorty.ui.theme.aLiveGreen
import com.ondev.rickandmorty.ui.theme.surface

@ExperimentalMaterialApi
@Composable
fun RickListRow(
    characterData: Character,
) {
    val rowHeightDp = 100.dp
    val standarPadding = 8.dp
    Card(
        backgroundColor = surface,
        modifier = Modifier.height(rowHeightDp).fillMaxWidth().padding(standarPadding),
        shape = RoundedCornerShape(10.dp),
        onClick = {}
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(standarPadding),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(62.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Inside,
                contentDescription = "RickCharacterAvatar",
                painter = rememberImagePainter(
                    data = characterData.image,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.rick_placeholder)
                    }
                )
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column(
                modifier = Modifier.width(200.dp)
                    .fillMaxHeight()
                    .padding(standarPadding)) {
                RickText(
                    text = characterData.name,
                    textSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (characterData.status == "Alive")
                        Box(modifier = Modifier.clip(CircleShape).size(4.dp).background(aLiveGreen))
                    else
                        Box(modifier = Modifier.clip(CircleShape).size(4.dp).background(aDeadRed))
                    Spacer(modifier = Modifier.padding(4.dp))
                    RickText(
                        text = characterData.status,
                        textSize = 14.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(standarPadding))
            RickText(
                text = characterData.gender,
                textSize = 14.sp,
            )
        }


    }
}

