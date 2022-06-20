package com.taxze.jetpack.livedata_viewmodel.same

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    private val numberLiveData = MutableLiveData<Int>()

    private var i = 0
    fun getLiveData(): LiveData<Int> {
        return numberLiveData
    }

    fun addOne(){
        i++
        numberLiveData.value = i
    }
}