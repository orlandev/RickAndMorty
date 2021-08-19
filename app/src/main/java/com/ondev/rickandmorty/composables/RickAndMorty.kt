package com.ondev.rickandmorty.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.ondev.rickandmorty.data.Character

@Composable
fun RickAndMorty(characterLiveData: LiveData<List<Character>>) {
    val characterData by characterLiveData.observeAsState(initial = emptyList())
    if (characterData.isEmpty()) {
        ShowLoading()
    } else {
        RickAndMortyCharactersList(characterData)
    }
}