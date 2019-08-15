package com.example.applibrary

import android.content.Context
import android.widget.Toast
import com.example.applibrary.apicalls.RetrofitClientInstance
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Preferences {
    companion object {
        var jsonString: String? = null
        var values: HashMap<*,*>? = null

        fun storeJson(context: Context) {
            RetrofitClientInstance.retrofitInstance.getAppUIPreferences()
                .enqueue(object: Callback<Any> {
                    override fun onFailure(call: Call<Any>, t: Throwable) {
                        Toast.makeText(context, "Error retrieving preferences from server.", Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        if(response.isSuccessful) {
                            val body = response.body()
                            jsonString = body?.toString()
                            values = Gson().fromJson(jsonString, HashMap::class.java)
                        }
                    }
                })
        }
    }
}