package com.taxze.jetpack.livedata_viewmodel.count

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _mycount: MutableLiveData<Int> = MutableLiveData()

    val mycount: LiveData<Int> get() = _mycount

    init {
        _mycount.value = 0
    }

    /**
     * mycount.value若为空就赋值为0，不为空则加一
     * */
    fun add() {
        _mycount.value = _mycount.value?.plus(1)
    }

    /**
     * mycount.value若为空就赋值为0，不为空则减一，可以为负数
     * */
    fun reduce() {
        _mycount.value = _mycount.value?.minus(1)
    }

    /**
     * 随机参数
     * */
    fun random() {
        val random = (0..100).random()
        _mycount.value = random
    }

    /**
     * 清除数据
     * */
    fun clear() {
        _mycount.value = 0
    }
}