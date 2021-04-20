package com.example.becamobile03android_squad2.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.favorite.CoinFavorite
import com.example.becamobile03android_squad2.helpers.CoinDate
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.viewModel.CoinViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_bar.*


class MainActivity : AppCompatActivity() {
<<<<<<< HEAD
   private val coinData = CoinDate()
=======
    private val coinData = CoinDate()
>>>>>>> develop
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: CoinViewModel by viewModels()
        viewModel.init()
        viewModel.listCoin.observe(this, Observer{
            setAdapter(it)
            searchListDisplay(it)
<<<<<<< HEAD

           // button_star.setOnClickListener {
           //     clickButton(it)
            //}
=======
>>>>>>> develop
        }
        )

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

<<<<<<< HEAD
=======

    private fun resultListSearch( search: String, list: List<Coin>){
        var lisResultSearch :MutableList<Coin> = arrayListOf()
        for(element in list){
            if(element.name != null ){
                if(element.name!!.contains(search,ignoreCase = true)){
                    lisResultSearch.add(element)
                }
            }
        }
        setAdapter(lisResultSearch)
    }


    private fun searchListDisplay(list: List<Coin>) {
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                resultListSearch(query, list)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                resultListSearch(newText, list)
                return false
            }
        })
>>>>>>> develop

    private fun resultListSearch( search: String, list: List<Coin>){
        var lisResultSearch :MutableList<Coin> = arrayListOf()
        for(element in list){
            if(element.name != null ){
                if(element.name!!.contains(search,ignoreCase = true)){
                    lisResultSearch.add(element)
                }
            }
        }
        setAdapter(lisResultSearch)
    }

<<<<<<< HEAD
    private fun searchListDisplay(list: List<Coin>) {
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                resultListSearch(query, list)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                resultListSearch(newText, list)
                return false
            }
        })
    }

 // private fun clickButton(view: View){
     // val page = button_star.id
     // if(page == view.id){
      //    val intent = Intent(this, CoinFavorite::class.java)
     //     startActivity(intent)
     // }
  //}
=======

>>>>>>> develop
}