package com.example.becamobile03android_squad2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            setAdapeter(it)
        }

        )
    }
    private fun setAdapeter(coin: List<Coin>?) {
        moeda.layoutManager = GridLayoutManager(this@MainActivity, 1)
        moeda.adapter = coin?.let {
            CoinAdapter(
                coin,
                this
            )
        }
    }


    fun ClickCoin(coin: Coin){
        var intent =  Intent(this, DetalhesCoin::class.java)
        intent.putExtra("coin", coin)
        startActivity(intent)

    }
}