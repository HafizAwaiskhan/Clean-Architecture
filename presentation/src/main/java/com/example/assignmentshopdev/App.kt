package com.example.assignmentshopdev

import android.app.Application
import com.example.assignmentshopdev.di.iteratorsModule
import com.example.assignmentshopdev.di.networkModule
import com.example.assignmentshopdev.di.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber


class App : Application() {


    override fun onCreate() {
        super.onCreate()

        // Set up Timber to see logs
        setUpTimber()
        // Next step is set up DI with Koin
        setUpKoin()

    }


    private fun setUpTimber() {
        // Build crash reporting tree only if this option
        // is enabled for current build type
        if (BuildConfig.CRASH_REPORTING_ENABLED) {

        } else {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setUpKoin() {
        // Start Koin for DI
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    repositoriesModule,
                    iteratorsModule,
                    networkModule
                )
            )

        }
    }

}