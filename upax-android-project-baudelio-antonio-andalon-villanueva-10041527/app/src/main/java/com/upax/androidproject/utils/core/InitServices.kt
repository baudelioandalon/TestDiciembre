package com.upax.androidproject.utils.core

import com.upax.androidproject.utils.core.retrofit.ApiServices
import com.upax.androidproject.utils.core.retrofit.RetroClient

class InitServices<R> {
    fun executeService(endPoint: String) =
        RetroClient.getRestEngine().create(ApiServices::class.java)
            .serviceResponseBody(endPoint) as R
}
