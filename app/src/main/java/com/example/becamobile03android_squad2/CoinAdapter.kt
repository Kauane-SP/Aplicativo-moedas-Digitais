package com.example.becamobile03android_squad2

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CoinViewHolder(
    itemView: View,
    var list: MutableList<Coin>,
    var listeners: MainActivity
) : RecyclerView.ViewHolder(itemView) {

}