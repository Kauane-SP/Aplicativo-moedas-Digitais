package com.example.becamobile03android_squad2

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CoinData {

    @RequiresApi(Build.VERSION_CODES.O)
    fun callDate() : String{
        val data =  LocalDateTime.now()
        val style = DateTimeFormatter.ofPattern("dd MMM yyyy")
        return data.format(style).toString()
    }
}