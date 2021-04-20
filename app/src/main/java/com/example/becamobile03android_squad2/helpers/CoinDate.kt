package com.example.becamobile03android_squad2.helpers

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class CoinDate {

    fun callDate() : String{
        val date = Calendar.getInstance().time
        var dateTimeFormat = SimpleDateFormat("d MMM yyyy")
        return dateTimeFormat.format(date)
    }
}