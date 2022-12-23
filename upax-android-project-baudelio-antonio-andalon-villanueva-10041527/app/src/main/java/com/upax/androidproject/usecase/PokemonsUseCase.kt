package com.upax.androidproject.usecase


import com.upax.androidproject.domain.PokemonsRepository
import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.domain.model.PokemonResultModel
import com.upax.androidproject.utils.core.DataResponse
import com.upax.androidproject.utils.core.In
import com.upax.androidproject.utils.core.Out
import com.upax.androidproject.utils.core.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PokemonsUseCase(private val pokemonsRepository: PokemonsRepository) :
    UseCase<PokemonsUseCase.Input, PokemonsUseCase.Output> {

    class Input : In()
    inner class Output(val response: DataResponse<PokemonResponseModel>) : Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return pokemonsRepository.getPokemons()
            .flowOn(Dispatchers.IO).map {
                Output(it)
            }
    }

}