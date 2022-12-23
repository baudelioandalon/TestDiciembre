package com.upax.androidproject.data.datasource

import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.utils.core.DataResponse

interface GetPokemonsDataSource {
    suspend fun getPokemons(): DataResponse<PokemonResponseModel>
}