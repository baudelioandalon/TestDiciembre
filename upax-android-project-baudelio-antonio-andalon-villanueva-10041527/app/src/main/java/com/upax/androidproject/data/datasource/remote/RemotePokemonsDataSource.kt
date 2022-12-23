package com.upax.androidproject.data.datasource.remote

import com.upax.androidproject.data.datasource.GetPokemonsDataSource
import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.utils.core.DataResponse

class RemotePokemonsDataSource : GetPokemonsDataSource {
    override suspend fun getPokemons(): DataResponse<PokemonResponseModel> {
        return PokemonsDataSource.getData()
    }
}
