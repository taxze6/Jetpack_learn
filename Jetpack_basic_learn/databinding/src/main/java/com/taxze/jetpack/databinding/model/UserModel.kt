package com.taxze.jetpack.databinding.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class UserModel(application: Application) : AndroidViewModel(application) {
    var UserName = MutableLiveData("")
}