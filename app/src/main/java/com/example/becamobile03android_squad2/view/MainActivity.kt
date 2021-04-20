package com.example.becamobile03android_squad2.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.becamobile03android_squad2.MainFragment
import com.example.becamobile03android_squad2.helpers.ClickListener
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.favorite.CoinFavorite
import com.example.becamobile03android_squad2.helpers.ButtonNavigation
import com.example.becamobile03android_squad2.helpers.CoinData
import com.example.becamobile03android_squad2.model.Coin
import kotlinx.android.synthetic.main.nav_bar.*


class MainActivity : AppCompatActivity(), View.OnClickListener, ClickListener {

    private val btnNavigation = ButtonNavigation()
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
        btnNavigation.buttonNavigation(button_main, txt_main, "#9a9b54")
    }

    override fun onClick(v: View?) {
        val id = v?.id

        when{
            (id == R.id.button_main) -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            (id == R.id.button_star) -> {
                val intentFavorite = Intent(this, CoinFavorite::class.java)
                startActivity(intentFavorite)
            }
        }
    }

    override fun ClickList(coin: Coin) {
        TODO("Not yet implemented")
    }

}