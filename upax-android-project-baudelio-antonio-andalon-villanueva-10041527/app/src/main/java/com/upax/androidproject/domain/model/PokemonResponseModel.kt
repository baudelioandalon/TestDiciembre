package com.upax.androidproject.domain.model

data class PokemonResponseModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonResultModel>
)