package com.upax.androidproject.data.datasource.remote


import com.upax.androidproject.BuildConfig
import com.upax.androidproject.domain.Endpoint
import com.upax.androidproject.domain.model.PokemonResponseModel
import com.upax.androidproject.utils.core.DataResponse
import com.upax.androidproject.utils.core.InitServices
import com.upax.androidproject.utils.core.StatusRequestEnum
import com.upax.androidproject.utils.core.ValidResponse
import retrofit2.Call
import java.net.UnknownHostException

class PokemonsDataSource {

    companion object {
        fun getData(): DataResponse<PokemonResponseModel> = try {
            ValidResponse<PokemonResponseModel>(PokemonResponseModel::class).validationMethod(
                InitServices<Call<PokemonResponseModel>>().executeService("${BuildConfig.BASE_URL}${Endpoint.GetList}")
            )
        } catch (exception: Exception) {
            if (exception is UnknownHostException) {
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    null,
                    errorData = "Por favor, revisa tu conexion a internet"
                )
            } else {
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    null,
                    errorData = "No se pudo completar la transaccion, por favor intenta mas tarde"
                )
            }
        }
    }

}
