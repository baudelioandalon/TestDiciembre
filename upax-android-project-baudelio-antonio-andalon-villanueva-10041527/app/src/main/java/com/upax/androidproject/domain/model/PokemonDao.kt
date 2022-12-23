package com.upax.androidproject.domain.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemonEntity")
    suspend fun getPokemons(): List<PokemonEntity>

    @Query("SELECT * FROM pokemonEntity WHERE id == :id")
    suspend fun getPokemonById(id: String): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePokemon(movie: PokemonEntity)

}