package com.upax.androidproject.di

import com.upax.androidproject.data.datasource.GetPokemonsDataSource
import com.upax.androidproject.data.datasource.remote.RemotePokemonsDataSource
import com.upax.androidproject.domain.PokemonsRepository
import com.upax.androidproject.repository.DefaultPokemonsRepository
import com.upax.androidproject.ui.MainViewModel
import com.upax.androidproject.usecase.PokemonsUseCase
import com.upax.androidproject.utils.core.UseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    single<GetPokemonsDataSource>(named("RemotePokemonsDataSource")) {
        RemotePokemonsDataSource()
    }
    single<PokemonsRepository>(named("DefaultPokemonsRepository")) {
        DefaultPokemonsRepository(get(named("RemotePokemonsDataSource")))
    }
    single<UseCase<PokemonsUseCase.Input, PokemonsUseCase.Output>>(named("PokemonsUseCase")) {
        PokemonsUseCase(get(named("DefaultPokemonsRepository")))
    }
    viewModel {
        MainViewModel(get(named("PokemonsUseCase")))
    }
}