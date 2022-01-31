package com.example.data.network

import android.content.Context
import com.example.data.BuildConfig
import com.example.data.utils.SupportInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


fun createHttpClient(context: Context): OkHttpClient {

    //ADD DISPATCHER WITH MAX REQUEST TO 1
    val dispatcher = Dispatcher()
    dispatcher.maxRequests = 1

    val okHttpClientBuilder = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)

    with(okHttpClientBuilder) {

        addInterceptor(SupportInterceptor(context))
        authenticator(SupportInterceptor(context))

        dispatcher(dispatcher)
        // Setup logging interceptor for debug builds
        if (BuildConfig.HTTP_LOGS_ENABLED) {
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }
    }
    return okHttpClientBuilder.build()
}

fun createConverterFactory(gson: Gson): Converter.Factory {
    return GsonConverterFactory.create(gson)
}

fun createGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}

inline fun <reified T> createApi(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    converterFactory: Converter.Factory
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()
    return retrofit.create()
}

