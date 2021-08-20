package com.ondev.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.ondev.rickandmorty.screens.RickAndMorty
import com.ondev.rickandmorty.ui.theme.RickAndMortyTheme
import com.ondev.rickandmorty.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.onLoadCharacters()

        setContent {
            RickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RickAndMorty(mainViewModel.charactersList)
                }
            }
        }
    }
}




