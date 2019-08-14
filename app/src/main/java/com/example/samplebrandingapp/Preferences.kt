package com.example.samplebrandingapp

import com.example.samplebrandingapp.network.response.*
import com.google.gson.Gson

class Preferences {
    companion object {
        var jsonString: String? = null
        var values = Gson().fromJson(jsonString, Map::class.java)
    }
}