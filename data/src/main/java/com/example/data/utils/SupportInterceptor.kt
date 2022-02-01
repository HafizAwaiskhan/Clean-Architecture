package com.example.data.utils

import android.content.Context
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.*

/**
 * Secondary helper interceptor to skip interceptor headers over Data Module
 */

class SupportInterceptor(context: Context) : Interceptor,
    Authenticator {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("Not yet implemented")
    }

    /**
     * Returns a request that includes a credential to satisfy an authentication challenge in
     * [response]. Returns null if the challenge cannot be satisfied.
     *
     * The route is best effort, it currently may not always be provided even when logically
     * available. It may also not be provided when an authenticator is re-used manually in an
     * application interceptor, such as when implementing client-specific retries.
     */




}
