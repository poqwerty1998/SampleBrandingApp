package com.example.applibrary

import android.content.Context
import android.graphics.Canvas
import android.widget.Button
import androidx.core.view.updateLayoutParams

class CustomButton(
    context: Context
) : Button(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun setProperties(width: Int, height: Int) {
        val params = this.layoutParams
        this.updateLayoutParams {
            params.width = width
            params.height = height
        }
    }
}