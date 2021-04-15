package com.example.becamobile03android_squad2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.model.Coin
import com.squareup.picasso.Picasso

class CoinAdapter(private val list: List<Coin>, private val listener: MainActivity) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coin, parent, false)

        return CoinViewHolder(
            View,
            list as MutableList<Coin>,
            listener
        )
    }


    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CoinViewHolder(
        itemView: View,
        var list: MutableList<Coin>,
        var listener: MainActivity
    ) : RecyclerView.ViewHolder(itemView) {
        private val listTitle: AppCompatTextView = itemView.findViewById(R.id.titulo_coin)
        private val imagem: AppCompatImageView = itemView.findViewById(R.id.imagem_coin)

        init{
            itemView.setOnClickListener{
                listener.ClickCoin(list[adapterPosition])
            }
        }

        fun bind(coin: Coin) {
            val imageId = coin.idIcon?.replace("-","")
            Picasso.get().load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_32/${imageId}.png").into(imagem)
            if (coin.name?.isNotEmpty() == true) {
                listTitle.text = coin.name.toString()
            }
        }
    }
}