package com.upax.androidproject.utils.core

import com.upax.androidproject.domain.ErrorModel

data class DataResponse<R>(
    val statusRequest: StatusRequestEnum = StatusRequestEnum.NONE,
    val successData: R? = null,
    val errorModel: ErrorModel? = null,
    var errorData: String? = null
)
