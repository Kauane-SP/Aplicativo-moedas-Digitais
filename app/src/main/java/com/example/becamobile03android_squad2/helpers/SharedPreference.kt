package com.example.becamobile03android_squad2.helpers

import android.content.Context

class SharedPreference(context: Context){

    private val myPreferences = context.getSharedPreferences("APP", Context.MODE_PRIVATE)

    fun funcBoolean(key: String, Value: Boolean){
        myPreferences.edit().putBoolean(key,Value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return myPreferences.getBoolean(key, false) ?: false
    }
}