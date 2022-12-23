package com.upax.androidproject.domain.model.item

data class Sprites(
    val back_default: String,
    val back_female: String ? = "",
    val back_shiny: String,
    val back_shiny_female: String ?= "",
    val front_default: String,
)