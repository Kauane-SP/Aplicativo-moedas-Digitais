package com.example.becamobile03android_squad2.helpers

import android.graphics.Color
import android.widget.ImageButton
import android.widget.TextView

class ButtonNavigation {
    fun buttonNavigation(imageButton: ImageButton, color: String) {
        imageButton.setColorFilter(Color.parseColor("$color"))
    }
}
