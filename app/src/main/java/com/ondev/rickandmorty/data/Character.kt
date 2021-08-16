package com.ondev.rickandmorty.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    val created: String,
    val episode: List<Any>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
)