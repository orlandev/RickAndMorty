package com.ondev.rickandmorty.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageCharacters(
    val info: Info,
    val results: List<Character>,
)