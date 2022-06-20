package com.taxze.jetpack.livedata_viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import com.taxze.jetpack.livedata_viewmodel.count.MainViewModel
import com.taxze.jetpack.livedata_viewmodel.count.SecondActivity
import com.taxze.jetpack.livedata_viewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @VMScope("count")
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectViewModel()
        initEvent()
    }

    private fun initEvent() {
        val cardReduce: CardView = findViewById(R.id.card_reduce)
        val cardAdd: CardView = findViewById(R.id.card_add)
        val sendMessage: Button = findViewById(R.id.send_message)
        val countTv: TextView = findViewById(R.id.count_tv)
        cardReduce.setOnClickListener {
            viewModel.reduce()
        }
        cardAdd.setOnClickListener {
            viewModel.add()
        }
        sendMessage.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        clear_message.setOnClickListener {
            viewModel.clear()
        }
        /**
         *  订阅 ViewModel,mycount是一个LiveData类型 可以观察
         * */
        viewModel.mycount.observe(this@MainActivity) {
            countTv.text = viewModel.mycount.value.toString()
        }

// LiveData onchange会自动感应生命周期 不需要手动
//        viewModel.mycount.observe(this, object : Observer<Int> {
//            override fun onChanged(t: Int?) {
//
//            }
//        })
    }
}