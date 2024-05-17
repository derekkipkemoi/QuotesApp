package com.quotes.app.quotesapp.utils

import android.graphics.Color
import java.util.Random

object UtilityFunctions{
    fun generateRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}

