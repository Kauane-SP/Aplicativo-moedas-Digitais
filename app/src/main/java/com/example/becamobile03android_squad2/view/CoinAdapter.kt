package com.example.becamobile03android_squad2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.helpers.SharedPreference
import com.example.becamobile03android_squad2.model.Coin
import com.squareup.picasso.Picasso

class CoinAdapter(private var list: List<Coin>, private var listener: MainActivity) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coin, parent, false)

        return CoinViewHolder(view, list, listener)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CoinViewHolder(
        itemView: View,
        list: List<Coin>,
        listener: MainActivity
    ) : RecyclerView.ViewHolder(itemView) {
        private val listTitle: AppCompatTextView = itemView.findViewById(R.id.name_coin)
        private val idName: AppCompatTextView = itemView.findViewById(R.id.id_coin)
        private val listPrice: AppCompatTextView = itemView.findViewById(R.id.price_usd)
        private val imgCoin: AppCompatImageView = itemView.findViewById(R.id.imgcoin)
        private var sharedPreferences = SharedPreference(this)
        private val starFavorite: AppCompatImageView = itemView.findViewById(R.id.favorite_star)


        init {
            itemView.setOnClickListener {
                listener.clickCoin(list[adapterPosition])
            }
        }

        fun bind(coin: Coin) {

            val imageId = coin.idIcon?.replace("-", "")
            Picasso.get()
                .load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_32/${imageId}.png")
                .placeholder(R.mipmap.ic_launcher_round)
                .into(imgCoin)
            if (coin.name?.isNotEmpty() == true) {
                listTitle.text = coin.name.toString()
                idName.text = coin.assetId.toString()
                listPrice.text = coin.priceUsd.toString()
            }
                if (coin.assetId?.let { sharedPreferences.getBoolean(it) } == true) {
                    starFavorite.visibility = View.VISIBLE
                } else if (!coin.assetId?.let { sharedPreferences.getBoolean(it) }!!) {
                    starFavorite.visibility = View.GONE
                }
            }
        }
}