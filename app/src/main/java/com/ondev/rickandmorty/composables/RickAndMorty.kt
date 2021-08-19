package com.ondev.rickandmorty.composables

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.ondev.rickandmorty.data.Character

@ExperimentalMaterialApi
@Composable
fun RickAndMorty(charactersList: LiveData<List<Character>>) {

    val characterData by charactersList.observeAsState(initial = emptyList())

    if (characterData.isEmpty()) {
        SplashScreen()
    } else {
        RickAndMortyCharactersList(characterData)
    }
}