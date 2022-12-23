package com.upax.androidproject.domain

sealed class Endpoint(val urlEndpoint: String){
    object GetList: Endpoint("pokemon/")
}