package com.upax.androidproject.main

import android.app.Application
import androidx.room.Room
import com.upax.androidproject.di.activityModule
import com.upax.androidproject.ui.MainViewModel
import com.upax.androidproject.utils.core.TestDataBase
import org.koin.core.context.startKoin

class TestApplication : Application() {
    companion object {
        lateinit var roomDatabase: TestDataBase
    }

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(activityModule) }

        roomDatabase = Room.databaseBuilder(applicationContext, TestDataBase::class.java, "db_test")
            .build()
    }
}