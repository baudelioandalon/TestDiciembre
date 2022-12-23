package com.upax.androidproject.utils.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.upax.androidproject.domain.model.PokemonDao
import com.upax.androidproject.domain.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class TestDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}