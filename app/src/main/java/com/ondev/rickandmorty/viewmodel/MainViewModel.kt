package com.ondev.rickandmorty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ondev.rickandmorty.api.RickApi
import com.ondev.rickandmorty.data.Character
import com.ondev.rickandmorty.data.PageCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val retrofit: Retrofit) : ViewModel() {

    private val _loadingFromInternet = MutableLiveData<Boolean>()
    val loadingFromInternet: LiveData<Boolean> = _loadingFromInternet

    private val _pageCharacters = MutableLiveData<PageCharacters>()
    val pageCharacters: LiveData<PageCharacters> = _pageCharacters

    private val _charactersList = MutableLiveData<List<Character>>()
    val charactersList: LiveData<List<Character>> = _charactersList


    private val _errorLoadingData = MutableLiveData(false)
    val errorLoadingData: LiveData<Boolean> = _errorLoadingData

    fun onLoadCharacters() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                _loadingFromInternet.value = true
                Log.d("RETROFIT",
                    "onLoadCharacters: Loading...")

                val pageCharacters = withContext(Dispatchers.IO) {
                    retrofit.create(RickApi::class.java).loadCharacters()
                }

                Log.d("RETROFIT",
                    "onLoadCharacters: Stoped connexion")

                if (pageCharacters.results.isNotEmpty()) {
                    Log.d("RETROFIT",
                        "onLoadCharacters: Loaded Charactres: ${pageCharacters.results.size}")
                    _pageCharacters.value = pageCharacters
                    _charactersList.value = pageCharacters.results
                }

                Log.d("RETROFIT",
                    "onLoadCharacters: Finish Loading...")
                _loadingFromInternet.value = false
            } catch (socketException: java.net.SocketTimeoutException) {

                Log.d("RETROFIT",
                    "onLoadCharacters: ERROR Loading data...: ${socketException.message}")

                _errorLoadingData.value = true

                _loadingFromInternet.value = false
            }

        }
    }

}