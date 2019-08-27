package com.example.samplebrandingapp

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button

class MyButton : Button {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        this.setBackgroundColor(Color.RED)
        this.setTextColor(Color.GRAY) //change color as per your need here.
    }
}