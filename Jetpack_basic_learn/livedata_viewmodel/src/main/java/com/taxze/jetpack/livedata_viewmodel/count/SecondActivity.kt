package com.taxze.jetpack.livedata_viewmodel.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.taxze.jetpack.livedata_viewmodel.R
import com.taxze.jetpack.livedata_viewmodel.VMScope
import com.taxze.jetpack.livedata_viewmodel.databinding.ActivitySecondBinding
import com.taxze.jetpack.livedata_viewmodel.injectViewModel

class SecondActivity : AppCompatActivity() {
    @VMScope("count")
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        injectViewModel()
        initEvent()
    }

    private fun initEvent() {
        val countRandom: Button = findViewById(R.id.count_random)
        val back: Button = findViewById(R.id.back)
        val countSecondTv: TextView = findViewById(R.id.count_second_tv)
        countRandom.setOnClickListener {
            viewModel.random()
        }
        back.setOnClickListener {
            finish()
        }
        /**
         * mycount是一个LiveData类型 可以观察
         * */
        viewModel.mycount.observe(this@SecondActivity) {
            countSecondTv.text = viewModel.mycount.value.toString()
        }
    }
}