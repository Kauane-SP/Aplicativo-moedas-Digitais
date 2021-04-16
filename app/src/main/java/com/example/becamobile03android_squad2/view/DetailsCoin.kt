package com.example.becamobile03android_squad2.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.model.Coin
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_coin.*

class DetailsCoin : AppCompatActivity() {

    private var itemId: String? = ""
    private var priceId: String? = ""
    private var hourId: String? = ""
    private var dayId: String? = ""
    private var monthId: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_coin)

        getExtra()
       setupToolbar(toolbar_back, "Voltar", true)
    }
        private fun getExtra(){
            if(intent.extras != null){
                val coin = intent.getParcelableExtra("coin") as? Coin
                itemId = coin?.assetId
                priceId = coin?.priceUsd
                hourId = coin?.volumeHour
                dayId = coin?.volumeDay
                monthId = coin?.volumeMonth


                price_day.text = coin?.priceUsd
                volume_1hrs_usd.text = coin?.volumeHour
                volume_1day_usd.text = coin?.volumeDay
                volume_1mth_usd.text = coin?.volumeMonth
                val image = coin?.idIcon?.replace("-","")
                Picasso.get().load("https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_32/${image}.png").into(id_icon)


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

}