package com.example.becamobile03android_squad2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinViewModel : ViewModel() {

    val listCoinResult: MutableList<Coin> = arrayListOf()
    private val coinLiveData: MutableLiveData<List<Coin>> = MutableLiveData()
    val listCoin: LiveData<List<Coin>>
        get() = coinLiveData
}