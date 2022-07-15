package com.taxze.jetpack.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.taxze.jetpack.room.entity.UserEntity


@Dao
interface UserDao {
    //添加用户
    @Insert
    fun addUser(vararg userEntity: UserEntity)

    //删除用户
    @Delete
    fun deleteUser(vararg userEntity: UserEntity)

    //更新用户
    @Update
    fun updateUser(vararg userEntity: UserEntity)

    //查找用户
    //返回user表中所有的数据
    @Query("select * from user")
    fun getUserData(): LiveData<List<UserEntity>>


    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    fun loadAllUsersBetweenAges(minAge: Int, maxAge: Int): Array<UserEntity>

}
