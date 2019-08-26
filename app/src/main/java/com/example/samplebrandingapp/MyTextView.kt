package com.example.samplebrandingapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import com.example.repository.data.db.Preferences

class MyTextView : TextView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    /*override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.setTextColor(Preferences.color) //change color as per your need here.
    }*/
    init {
        this.setTextColor(Color.GREEN) //change color as per your need here.
    }
}
