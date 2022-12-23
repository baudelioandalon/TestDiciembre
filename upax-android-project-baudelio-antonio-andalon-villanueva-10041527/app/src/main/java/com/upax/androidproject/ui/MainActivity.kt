package com.upax.androidproject.ui

import com.boreal.commonutils.application.CUAppInit
import com.boreal.commonutils.base.CUBaseActivity
import com.upax.androidproject.R
import com.upax.androidproject.databinding.ActivityMainBinding
import com.upax.androidproject.utils.core.StatusRequestEnum
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : CUBaseActivity<ActivityMainBinding>() {

    override fun getLayout() = R.layout.activity_main

    val viewModel: MainViewModel by viewModel()

    override fun initView() {
        CUAppInit().init(this.application, this)
        initElements()
    }

    override fun initObservers() {

        viewModel.pokemonList.observe(this) {
            it?.let {
                if (it.statusRequest == StatusRequestEnum.SUCCESS) {
                    it.successData?.let { items ->
                        viewModel.savePokemonList( items.results)
                    }
                } else if (it.statusRequest == StatusRequestEnum.FAILURE) {
                    viewModel.getLocalPokemons {  listLocal ->
                        viewModel.retrieveData(listLocal)
                    }
                }
            }
        }

    }
}