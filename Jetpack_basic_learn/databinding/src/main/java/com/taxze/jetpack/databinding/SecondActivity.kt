package com.taxze.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.taxze.jetpack.databinding.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var viewDataBinding: ActivitySecondBinding
    lateinit var userName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //绑定页面
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        //绑定生命周期
        viewDataBinding.lifecycleOwner = this

        userName = intent.getStringExtra("user").toString()

        viewDataBinding.tvName.text = "登录的账号是：$userName"
    }
}