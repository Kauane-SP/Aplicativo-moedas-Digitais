package com.example.becamobile03android_squad2.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.helpers.SharedPreference
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.view.DetailsCoin
import com.example.becamobile03android_squad2.view.MainActivity
import com.example.becamobile03android_squad2.viewModel.CoinViewModel
import kotlinx.android.synthetic.main.activity_coin_favorite.*
import kotlinx.android.synthetic.main.activity_coin_favorite.button_star
import kotlinx.android.synthetic.main.activity_main.*

class CoinFavorite : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_favorite)
        sharedPreference = SharedPreference(this)
        val viewModel: CoinViewModel by viewModels()
        viewModel.init()
        viewModel.listCoin.observe(this, Observer {
            setAdapter(createListFavorite(it))
            button_main_favorite.setOnClickListener { onClick(it) }

        })
    }

    private fun setAdapter(coin: List<Coin>?) {
        list_recycler_favorite.layoutManager = GridLayoutManager(this@CoinFavorite, 2)
        list_recycler_favorite.adapter = coin?.let {
            FavoriteAdapter(
                coin,
                this
            )
        }
    }

    fun clickCoin(coin: Coin) {
        val intent = Intent(this, DetailsCoin::class.java)
        intent.putExtra("coin", coin)
        startActivity(intent)
        finish()
    }

    private fun createListFavorite(list: List<Coin>): MutableList<Coin> {
        var listCoinFavorit: MutableList<Coin> = arrayListOf()
        for (element in list) {
            if (sharedPreference.getBoolean(element.assetId.toString())) {
                listCoinFavorit.add(element)
            }
        }
        return listCoinFavorit
    }

    fun onClick(view: View) {
        val id = view.id
        if (id == R.id.button_main_favorite) {
            finish()
        }
    }
}



