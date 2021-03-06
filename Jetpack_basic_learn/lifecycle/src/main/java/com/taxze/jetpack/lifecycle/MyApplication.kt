package com.taxze.jetpack.lifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyDefaultLifecycleObserver())
    }
}