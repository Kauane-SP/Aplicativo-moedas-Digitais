package com.example.becamobile03android_squad2.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.becamobile03android_squad2.ClickListener
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.view.MainActivity
import com.squareup.picasso.Picasso

class FavoriteAdapter (
    private var context: Context,
    private var list: List<Coin>,
    private var listener: ClickListener
    ) :
    BaseAdapter() {

        private var layoutInflater: LayoutInflater? = null

        override fun getCount(): Int {
            return list.size
        }

        override fun getItem(position: Int): List<Coin> {

            val listCoin: MutableList<Coin> = arrayListOf()
            val coin: Coin = Coin(
                list[position].assetId,
                list[position].name,
                list[position].typeCrypto,
                list[position].volumeHour,
                list[position].volumeDay,
                list[position].volumeMonth,
                list[position].priceUsd,
                list[position].idIcon,
                list[position].iconImage,
                list[position].favorite
            )

            listCoin.add(coin)
            return listCoin
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(
            position: Int,
            convView: View?,
            parent: ViewGroup?
        ): View? {

            var convView = convView

            if (layoutInflater == null) {
                layoutInflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            }
            if (convView == null) {
                convView = layoutInflater!!.inflate(R.layout.item_favorit_coin, null)
            }

            val title: AppCompatTextView? = convView?.findViewById(R.id.coin_name_favorit)
            val subTitle: AppCompatTextView? = convView?.findViewById(R.id.coin_sub_name_favorit)
            val value: AppCompatTextView? = convView?.findViewById(R.id.coin_value_favorit)
            val image: AppCompatImageView? = convView?.findViewById(R.id.coin_icon_favorit)

            val list: List<Coin> = getItem(position)

            convView?.setOnClickListener {
                listener.ClickList(list[0])
            }

            title?.text = list[0].name
            title?.contentDescription = "Nome da Moeda ${list[0].name}"

            subTitle?.text = list[0].assetId
            subTitle?.contentDescription = "Sigla da Moeda ${list[0].assetId}"

            value?.text = list[0].priceUsd
            value?.contentDescription = "Valor da Moeda ${list[0].priceUsd}"

          Picasso.get().load("${list[0].iconImage}.png")
               .placeholder(R.mipmap.ic_launcher)
              .into(image)

            return convView
        }
    }