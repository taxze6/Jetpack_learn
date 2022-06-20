package com.taxze.jetpack.livedata_viewmodel.same

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.taxze.jetpack.livedata_viewmodel.R
import kotlinx.android.synthetic.main.activity_main_two.*

class MainTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)
    }
}