package com.example.repository.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.myjson.com/"

object RetrofitClientInstance {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val retrofitInstance: AppPreferenceApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(AppPreferenceApiService::class.java)
    }
}