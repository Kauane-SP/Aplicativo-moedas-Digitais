package com.example.becamobile03android_squad2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.becamobile03android_squad2.*
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.viewModel.CoinViewModel
import kotlinx.android.synthetic.main.layout_tela_inicial.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.layout_tela_inicial)
        val viewModel: CoinViewModel by viewModels()
        viewModel.init()
        viewModel.listCoin.observe(this, Observer{
            setAdapter(it)
        }
        )

        val search = findViewById<SearchView>(R.id.searchBar)

    }
    private fun setAdapter(coin: List<Coin>?) {
        moeda.layoutManager = GridLayoutManager(this@MainActivity, 1)
        moeda.adapter = coin?.let {
            CoinAdapter(
                coin,
                this
            )
        }
    }


    fun clickCoin(coin: Coin){
        val intent =  Intent(this, DetailsCoin::class.java)
        intent.putExtra("coin", coin)
        startActivity(intent)

    }
}