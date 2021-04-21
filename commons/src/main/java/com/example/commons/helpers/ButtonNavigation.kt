package com.example.commons.helpers

import android.graphics.Color
import android.widget.ImageButton

class ButtonNavigation {
    fun buttonNavigation(imageButton: ImageButton, color: String) {
        imageButton.setColorFilter(Color.parseColor("$color"))
    }
}
