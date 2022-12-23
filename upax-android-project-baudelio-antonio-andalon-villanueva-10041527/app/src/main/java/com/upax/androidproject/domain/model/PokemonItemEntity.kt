package com.upax.androidproject.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemonItemEntity")
data class PokemonItemEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "url")
    val urlImage: String = "",
    @ColumnInfo(name = "url")
    val width: String = "",
    @ColumnInfo(name = "url")
    val weight: String = "",
    @ColumnInfo(name = "url")
    val types: String = ""
)