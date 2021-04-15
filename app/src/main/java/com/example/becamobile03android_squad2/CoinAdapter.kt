package com.example.becamobile03android_squad2

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CoinAdapter(private val list: List<Coin>, private val listener: MainActivity) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.CoinViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CoinAdapter.CoinViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

class CoinViewHolder(
    itemView: View,
    var list: MutableList<Coin>,
    var listeners: MainActivity
) : RecyclerView.ViewHolder(itemView) {

}