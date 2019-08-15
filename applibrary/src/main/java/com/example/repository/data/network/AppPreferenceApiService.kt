package com.example.repository.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.myjson.com/"

interface AppPreferenceApiService {
    @GET("bins/fpjil")
    fun getAppUIPreferences(): retrofit2.Call<Any>

    companion object {
        operator fun invoke(): AppPreferenceApiService {
            val okHttpClient = OkHttpClient.Builder()
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

            return retrofitInstance
        }
    }
}