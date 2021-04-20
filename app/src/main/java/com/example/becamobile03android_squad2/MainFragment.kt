package com.example.becamobile03android_squad2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.becamobile03android_squad2.model.Coin
import com.example.becamobile03android_squad2.view.CoinAdapter
import com.example.becamobile03android_squad2.viewModel.CoinViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment() {

    private lateinit var mainActivityViewModel : CoinViewModel

            override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
        mainActivityViewModel.getCoins()
        mainActivityViewModel.observeCoins(this) { handleCoins(it) }
    }

    private fun handleCoins(coin: List<Coin>) {
        list_recycler_coin?.layoutManager = LinearLayoutManager(context)
        list_recycler_coin?.adapter = context?.let { CoinAdapter(coin, it,this) }
        }
    }