package com.example.becamobile03android_squad2.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.helpers.SharedPreference
import com.example.becamobile03android_squad2.model.Coin
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_coin.*

class DetailsCoin : AppCompatActivity(), View.OnClickListener {

    private var iconId: String? = ""
    private var priceId: String? = ""
    private var hourId: String? = ""
    private var dayId: String? = ""
    private var monthId: String? = ""
    private var coin: Coin? = null
    private lateinit var sharedPreferences: SharedPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_coin)

        sharedPreferences = SharedPreference(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        button_favorite.setOnClickListener(this)
        getExtra()
       setupToolbar(toolbar_back, "Voltar", true)
        checkFavorite()
    }
        private fun getExtra(){
            if(intent.extras != null) {
                val coin = intent.getParcelableExtra("coin") as? Coin
                iconId = coin?.assetId
                priceId = coin?.priceUsd
                hourId = coin?.volumeHour
                dayId = coin?.volumeDay
                monthId = coin?.volumeMonth

                id_coin.text = coin?.assetId
                price_day.text = coin?.priceUsd
                volume_1hrs_usd.text = coin?.volumeHour
                volume_1day_usd.text = coin?.volumeDay
                volume_1mth_usd.text = coin?.volumeMonth


                val image = coin?.idIcon?.replace("-", "")
                Picasso.get()
                    .load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_32/${image}.png")
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(id_icon)
            }
    }

    fun setupToolbar(toolbar: androidx.appcompat.widget.Toolbar, title: String, navigationBack: Boolean){
      toolbar.title = title
        setSupportActionBar(toolbar)
     supportActionBar?.setDisplayHomeAsUpEnabled(navigationBack)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
             this.onBackPressed()
             return true
          }
        }
      return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.button_favorite -> {
                val statusButton = button_favorite.text.toString()
                if (statusButton == "ADICIONAR") {
                    sharedPreferences.funcBoolean(coin?.assetId.toString(), true)
                    checkFavorite()
                } else if (statusButton == "REMOVER") {
                    sharedPreferences.funcBoolean(coin?.assetId.toString(), false)
                    checkFavorite()
                }
            }
        }
    }

    private fun checkFavorite() {
        val favoriteStatus = sharedPreferences.getBoolean(coin?.assetId.toString())
        if (favoriteStatus) {
            button_favorite.text = getString(R.string.btn_delete)
            button_favorite.contentDescription = getString(R.string.btn_delete)
            coin?.favorite = false
        } else if (!favoriteStatus) {
            button_favorite.text = getString(R.string.btn_include)
            button_favorite.contentDescription = getString(R.string.btn_include)
            coin?.favorite = true
        }
    }
}