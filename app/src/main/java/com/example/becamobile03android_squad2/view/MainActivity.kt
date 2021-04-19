package com.example.becamobile03android_squad2.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.becamobile03android_squad2.MainFragment
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.helpers.CoinData
import com.example.becamobile03android_squad2.model.Coin


class MainActivity : AppCompatActivity() {
    private val coinData = CoinData()
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .commitNow()
       }


        val date: TextView = findViewById(R.id.data_coin_top_bar)
        date.text = coinData.callDate()
        date.contentDescription = coinData.callDate()
    }

}