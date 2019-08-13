package com.example.samplebrandingapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
import com.example.samplebrandingapp.network.apicalls.RetrofitClientInstance
import com.example.samplebrandingapp.network.response.UIConfigResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        val appTheme = getThemeID()
        setTheme(appTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClientInstance.retrofitInstance.getAppUIPreferences()
            .enqueue(object: Callback<UIConfigResponse> {
                override fun onFailure(call: Call<UIConfigResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Something wrong", Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(call: Call<UIConfigResponse>, response: Response<UIConfigResponse>) {
                    if(response.isSuccessful) {
                        var body = response.body()
                        Preferences.heading1TextColor = body?.heading1TextColor
                        Preferences.heading4TextColor = body?.heading4TextColor
                        Preferences.navigationBarColor = body?.navigationBarColor
                        Preferences.normalTextColor = body?.normalTextColor
                        Preferences.primaryBackgroundColor = body?.primaryBackgroundColor
                        Preferences.smallTitleTextColor = body?.smallTitleTextColor
                        Preferences.tabbarColor = body?.tabbarColor
                        Preferences.tintColor = body?.tintColor
                        Preferences.titleTextColor = body?.titleTextColor
                    }
                }
            })
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.button -> {
                // theme 1
                val arial = resources.getFont(R.font.arial)
                text1.typeface = arial
            }
            R.id.button3 -> {
                // theme 2
                val calibri = resources.getFont(R.font.calibri)
                text1.typeface = calibri
            }
            R.id.button2 -> {
                // theme 3
                val timesNewRoman = resources.getFont(R.font.timesnewroman)
                text1.typeface = timesNewRoman
            }
            R.id.button4 -> {
                // reset to default
                val roboto = resources.getFont(R.font.roboto)
                text1.typeface = roboto
            }
            R.id.button5 -> {
                setThemeID(R.style.CustomAppTheme)
                recreate()
                /*finish()
                val intent = intent
                startActivity(intent)*/
            }
            R.id.button6 -> {
                setThemeID(R.style.AppTheme)
                recreate()
                /*finish()
                val intent = intent
                startActivity(intent)*/
            }
            R.id.next -> {
                val intent = Intent(this, Activity2::class.java)
                startActivity(intent)
            }

        }
    }

    private fun setThemeID(id: Int) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()
        editor.putInt("THEME_ID", id)
        editor.apply()
    }

    private fun getThemeID() : Int {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        return preferences.getInt("THEME_ID", R.style.AppTheme)
    }

}
