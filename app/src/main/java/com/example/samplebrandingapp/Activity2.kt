package com.example.samplebrandingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.repository.data.db.ColorPreference
import com.example.repository.data.db.Preferences
import com.google.gson.Gson

class Activity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        val appTheme = getThemeID()
        setTheme(appTheme)
        /*for(i in 0..Preferences.values?.keys?.size!!) {
            val key = Preferences.values?.keys?.elementAt(i)
            val colorString = Preferences.values?.get(Preferences.values?.keys?.elementAt(i)).toString()
            val color = Gson().fromJson(colorString, ColorPreference::class.java)
            val value = Color.argb(1.toFloat(), color.red.toFloat(), color.green.toFloat(), color.blue.toFloat())
            Preferences.values?.put(key, value)
        }*/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            // TODO: button to change color, corner radius, and dimensions of a button based on field entered
            R.id.change -> {
                val width = findViewById<EditText>(R.id.width).text.toString()
                val height = findViewById<EditText>(R.id.height).text.toString()
                if(width.isEmpty() || height.isEmpty()) {
                    Toast.makeText(this, "Width or height is empty.", Toast.LENGTH_SHORT).show()
                } else if(width.toInt() > 1000 && height.toInt() > 1000) {
                    Toast.makeText(this, "Width and height too large.", Toast.LENGTH_SHORT).show()
                } else if(width.toInt() > 1000) {
                    Toast.makeText(this, "Width too large.", Toast.LENGTH_SHORT).show()
                } else if(height.toInt() > 1000) {
                    Toast.makeText(this, "Height too large.", Toast.LENGTH_SHORT).show()
                } else {
                    /*Preferences.setValues(width.toInt(), height.toInt())
                    changebutton.apply {
                        val params = this.layoutParams
                        updateLayoutParams {
                            if(Preferences.width!= null && Preferences.height != null) {
                                params.width = Preferences.width!!
                                params.height = Preferences.height!!
                            }
                        }

                        val tabbarcolor = Preferences.tabbarColor
                        setBackgroundColor(
                            Color.argb(1.00.toFloat(),
                                tabbarcolor?.red?.toFloat()!!, tabbarcolor.green.toFloat(), tabbarcolor.blue.toFloat()))
                    }*/
                }
            }
            /* BUTTON COLOR:
            b = (Button)findViewById(R.id.Button01)
            b.setBackgroundColor(R.color.red)
            */

            /* BUTTON DIMENSIONS
            ViewGroup.LayoutParams params = myButton.getLayoutParams()
            params.width = number
            params.height = number
            myButton.setLayoutParams(params)
            */

            /* BUTTON CORNER RADIUS
            */

        }
    }
    private fun getThemeID() : Int {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        return preferences.getInt("THEME_ID", R.style.AppTheme)
    }
}
