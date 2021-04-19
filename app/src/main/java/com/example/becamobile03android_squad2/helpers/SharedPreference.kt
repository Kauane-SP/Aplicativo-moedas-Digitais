package com.example.becamobile03android_squad2.helpers

import android.content.Context
import com.example.becamobile03android_squad2.view.DetailsCoin

class SharedPreference(context: DetailsCoin){

    private val myPreferences = context.getSharedPreferences("FAVORITE", Context.MODE_PRIVATE)

    fun funcBoolean(key: String, Value: Boolean){
        myPreferences.edit().putBoolean(key,Value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return myPreferences.getBoolean(key, false) ?: false
    }
}