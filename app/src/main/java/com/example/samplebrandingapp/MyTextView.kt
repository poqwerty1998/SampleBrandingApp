package com.example.samplebrandingapp

import android.content.Context
import android.graphics.Color
import android.widget.TextView

class MyTextView(context: Context) : TextView(context) {
    init {
        // TODO Auto-generated constructor stub
        this.setTextColor(Color.GREEN) //change color as per your need here.
    }
}
