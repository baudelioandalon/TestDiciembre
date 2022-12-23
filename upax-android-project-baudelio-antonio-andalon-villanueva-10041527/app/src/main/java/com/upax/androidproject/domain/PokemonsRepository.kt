package com.upax.androidproject.domain

import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.domain.model.PokemonResultModel
import com.upax.androidproject.utils.core.DataResponse
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {
    suspend fun getPokemons(): Flow<DataResponse<PokemonResponseModel>>
}