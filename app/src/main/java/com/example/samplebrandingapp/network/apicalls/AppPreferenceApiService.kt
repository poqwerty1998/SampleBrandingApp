package com.example.samplebrandingapp.network.apicalls

import com.example.samplebrandingapp.network.response.UIConfigResponse
import retrofit2.Call
import retrofit2.http.GET

interface AppPreferenceApiService {
    @GET("bins/fpjil")
    fun getAppUIPreferences(): Call<Any>
    /*@GET("bins/fpjil")
    fun getAppsUIPreferences(): Call<String>*/
}