package com.example.becamobile03android_squad2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.becamobile03android_squad2.R
import com.example.becamobile03android_squad2.model.Coin

class DetailsCoin : AppCompatActivity() {

    private var itemId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_coin)

        getExtra()

    }
        private fun getExtra(){
            if(intent.extras != null){
                val coin = intent.getParcelableExtra("coin") as? Coin
                itemId = coin?.assetId

        }
    }
}