package com.example.becamobile03android_squad2.viewModel

import androidx.lifecycle.*
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.api.CoinService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

open class CoinViewModel : ViewModel() { val listCoinResult: MutableList<Coin> = arrayListOf()
    private val coinLiveData: MutableLiveData<List<Coin>> = MutableLiveData()
    val listCoin: MutableLiveData<List<Coin>>
        get() = coinLiveData
    fun init(){
        callListCoin()
    }

    private fun callListCoin() {
        val call = CoinService.coinRetrofitApi()
            .getAllList("CFB9107C-F454-4F93-B412-C7F15E3D284D")
        call.enqueue(object : retrofit2.Callback<List<Coin>> {
            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {
                if (response.isSuccessful)
                    response.body()?.forEach {
                        listCoinResult.add(it)
                    }
                coinLiveData.postValue(listCoinResult)
            }

            override fun onFailure(call: Call<List<Coin>>, t: Throwable) {
                coinLiveData.postValue(null)
            }
        })
    }

    fun getCoins() {
        viewModelScope.launch(Dispatchers.IO) {
            listCoin.postValue(listCoin.callListCoin())
        }
    }

    fun observeCoins(
            lifecycleOwner: LifecycleOwner,
            action: (List<Coin>) -> Unit
    ) = listCoin.observe(lifecycleOwner) { action(it) }
}

