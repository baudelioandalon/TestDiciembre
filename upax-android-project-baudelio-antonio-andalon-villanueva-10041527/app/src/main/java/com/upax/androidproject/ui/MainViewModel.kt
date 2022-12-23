package com.upax.androidproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.upax.androidproject.domain.model.PokemonEntity
import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.domain.model.PokemonResultModel
import com.upax.androidproject.main.TestApplication
import com.upax.androidproject.usecase.PokemonsUseCase
import com.upax.androidproject.utils.core.CUBaseViewModel
import com.upax.androidproject.utils.core.DataResponse
import com.upax.androidproject.utils.core.StatusRequestEnum
import com.upax.androidproject.utils.core.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPokemonsUseCase: UseCase<PokemonsUseCase.Input, PokemonsUseCase.Output>
) : CUBaseViewModel() {

    val pokemonList: LiveData<DataResponse<PokemonResponseModel>>
        get() = _pokemonList
    private val _pokemonList = MutableLiveData<DataResponse<PokemonResponseModel>>()


    fun requestPokemons() {
        executeFlow {
            _pokemonList.value = DataResponse(statusRequest = StatusRequestEnum.LOADING)
            getPokemonsUseCase.execute(PokemonsUseCase.Input()).catch {
                _pokemonList.value = DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    null, errorData = it.message ?: "Algo salio mal"
                )
            }.catch { cause ->
                cause
            }.collect {
                _pokemonList.postValue(it.response)
            }
        }
    }

    fun savePokemonList(items: List<PokemonResultModel>) {
        viewModelScope.launch(Dispatchers.IO) {
            items.forEachIndexed { index, model ->
                TestApplication.roomDatabase.pokemonDao().savePokemon(
                    PokemonEntity(
                        id = index,
                        name = model.name,
                        url = model.url
                    )
                )
            }
        }
    }

    fun retrieveData(list: List<PokemonResultModel>) {
        _pokemonList.value = DataResponse(
            statusRequest = StatusRequestEnum.SUCCESS_LOCAL,
            successData = PokemonResponseModel(0,"","",list),
                errorData = null
            )
    }

    fun getLocalPokemons( callbackList: (List<PokemonResultModel>) -> Unit) {
        executeFlow {
            val list = TestApplication.roomDatabase.pokemonDao().getPokemons()
            callbackList(list.map {
                PokemonResultModel(
                    name = it.name,
                    url = it.url
                )
            })
        }
    }

}