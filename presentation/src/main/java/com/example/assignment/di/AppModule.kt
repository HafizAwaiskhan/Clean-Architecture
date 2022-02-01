package com.example.assignment.di

import com.example.assignment.BuildConfig
import com.example.data.api.Api
import com.example.data.network.createApi
import com.example.data.network.createConverterFactory
import com.example.data.network.createGson
import com.example.data.network.createHttpClient
import com.example.data.repositories.main.MainRepositoryImpl
import com.example.domain.interactors.main.MainInteractor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module


val repositoriesModule: Module = module {
    single {
        MainRepositoryImpl(
            api = get()
        )
    }
}

val iteratorsModule: Module = module {
    single {
            MainInteractor(mainRepository =  get() as MainRepositoryImpl)
    }
}

val networkModule: Module = module {
    single {
        createApi<Api>(
            baseUrl = BuildConfig.BASE_API_URL,
            okHttpClient = get(),
            converterFactory = get()
        )
    }

    factory { createHttpClient(androidApplication().applicationContext) }
    factory { createConverterFactory(gson = get()) }
    factory { createGson() }
}