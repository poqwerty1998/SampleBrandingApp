package com.example.samplebrandingapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.example.repository.data.db.Preferences
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        Preferences.storeJson(applicationContext)
        val appTheme = getThemeID()
        setTheme(appTheme)
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.button -> {
                // theme 1
                val arial = resources.getFont(R.font.arial)
                text1.typeface = arial
                Preferences.color = Color.GREEN
            }
            R.id.button3 -> {
                // theme 2
                val calibri = resources.getFont(R.font.calibri)
                text1.typeface = calibri
                Preferences.color = Color.BLUE
            }
            R.id.button2 -> {
                // theme 3
                val timesNewRoman = resources.getFont(R.font.timesnewroman)
                text1.typeface = timesNewRoman
                Preferences.color = Color.RED
            }
            R.id.button4 -> {
                // reset to default
                val roboto = resources.getFont(R.font.roboto)
                Preferences.color = Color.BLACK
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
