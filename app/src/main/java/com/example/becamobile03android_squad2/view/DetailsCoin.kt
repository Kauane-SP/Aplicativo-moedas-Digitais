package com.example.becamobile03android_squad2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.model.Coin
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

    }
        private fun getExtra(){
            if(intent.extras != null){
                val coin = intent.getParcelableExtra("coin") as? Coin
                itemId = coin?.assetId
                priceId = coin?.priceUsd
                hourId = coin?.volumeHour
                dayId = coin?.volumeDay
                monthId = coin?.volumeMonth

                id_coin.text = coin?.assetId
                price_day.text = coin?.priceUsd
                volume_1hrs_usd.text = coin?.volumeHour
                volume_1day_usd.text = coin?.volumeDay
                volume_1mth_usd.text = coin?.volumeMonth

            }
    }

}