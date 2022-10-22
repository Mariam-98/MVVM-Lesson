package com.example.mvvmlesson.applic

import android.app.Application
import com.example.mvvmlesson.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Applic: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Applic)
            modules(appModule)
        }
    }
}