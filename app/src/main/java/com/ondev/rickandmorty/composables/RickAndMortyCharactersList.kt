package com.ondev.rickandmorty.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ondev.rickandmorty.data.Character

@Composable
fun RickAndMortyCharactersList(rickCharactersList: List<Character>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(rickCharactersList) { character ->
                RickListRow(characterData = character)
            }
        }
    }
}