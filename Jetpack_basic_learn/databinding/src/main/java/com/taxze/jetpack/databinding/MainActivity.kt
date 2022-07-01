package com.taxze.jetpack.databinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.taxze.jetpack.databinding.databinding.ActivityMainBinding
import com.taxze.jetpack.databinding.model.UserModel


class MainActivity : AppCompatActivity() {
    lateinit var viewDataBinding: ActivityMainBinding
    lateinit var model: UserModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //绑定页面
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //绑定生命周期
        viewDataBinding.lifecycleOwner = this

        model = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
            .create(UserModel::class.java)
        viewDataBinding.loginModel = model

        viewDataBinding.button.setOnClickListener {
            val intent = Intent(MainActivity@ this, SecondActivity::class.java)
            intent.putExtra("user", "${model.UserName.value}")
            startActivity(
                intent
            )
        }
    }
}