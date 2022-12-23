package com.upax.androidproject.repository

import com.upax.androidproject.data.datasource.GetPokemonsDataSource
import com.upax.androidproject.domain.PokemonsRepository
import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.utils.core.DataResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultPokemonsRepository(
    private val getPokemonsDataSource: GetPokemonsDataSource
) : PokemonsRepository {
    override suspend fun getPokemons(): Flow<DataResponse<PokemonResponseModel>> = flow {
        emit(getPokemonsDataSource.getPokemons())
    }
}