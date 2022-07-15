package com.taxze.jetpack.room.viewModel

import androidx.lifecycle.ViewModel
import com.taxze.jetpack.room.dao.UserDao

class UserViewModel(userDao: UserDao):ViewModel(){
    var userLivedata = userDao.getUserData()
}
