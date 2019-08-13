package com.example.samplebrandingapp

import com.example.samplebrandingapp.network.response.*

class Preferences {
    companion object {
        var heading1TextColor: Heading1TextColor? = null
        var heading4TextColor: Heading4TextColor? = null
        var navigationBarColor: NavigationBarColor? = null
        var normalTextColor: NormalTextColor? = null
        var primaryBackgroundColor: PrimaryBackgroundColor? = null
        var smallTitleTextColor: SmallTitleTextColor? = null
        var tabbarColor: TabbarColor? = null
        var tintColor: TintColor? = null
        var titleTextColor: TitleTextColor? = null

        var width: Int? = null
        var height: Int? = null
        var prefURL: String = ""

        fun setValues(width: Int, height: Int) {
            this.width = width
            this.height = height
        }
    }
    fun parseJsonString() {

    }
}