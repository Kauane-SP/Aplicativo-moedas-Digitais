package com.example.becamobile03android_squad2.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.becamobile03android_squad2.*
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.viewModel.CoinViewModel
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    private val coinData = CoinData()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: CoinViewModel by viewModels()
        viewModel.init()
        viewModel.listCoin.observe(this, Observer{
            setAdapter(it)
        }
        )
     //   main_return.setOnClickListener {
       //     pageStart(it)
        //}

        //main_detalhes.setOnClickListener{
          //  pageStart(it)
        //}

        val search = findViewById<SearchView>(R.id.searchBar)

        val date: TextView = findViewById(R.id.data_coin_top_bar)
        date.text = coinData.callDate()
        date.contentDescription = coinData.callDate()


    }
    private fun setAdapter(coin: List<Coin>?) {
        list_recycler_coin.layoutManager = GridLayoutManager(this@MainActivity, 1)
        list_recycler_coin.adapter = coin?.let {
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

   /* fun pageStert(view: View){
        val page = view.id

        when {
            (page == R.id.main_return) ->{
                val intent = Inten(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            (page == R.id.main_detalhes) ->{
                val intentDetails = Inten(this, CoinFavorit::class.java)
                startActivity(intentDetails)

        }

    }

    }*/
}