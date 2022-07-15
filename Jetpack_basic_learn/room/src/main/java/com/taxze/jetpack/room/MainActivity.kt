package com.taxze.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.taxze.jetpack.room.dao.UserDao
import com.taxze.jetpack.room.db.UserDatabase
import com.taxze.jetpack.room.entity.UserEntity
import com.taxze.jetpack.room.viewModel.UserViewModel
import com.taxze.jetpack.room.viewModel.UserViewModelFactory
import java.util.concurrent.ThreadPoolExecutor
import kotlin.concurrent.thread

private const val TAG = "My_MainActivity"

class MainActivity : AppCompatActivity() {
    private var userList: MutableList<UserEntity> = arrayListOf()
    private lateinit var arrayAdapter: ArrayAdapter<UserEntity>
    private val userDao by lazy {
        UserDatabase.getInstance(this).getUserDao()
    }
    lateinit var viewModel: UserViewModel
    private lateinit var listView: ListView
    private lateinit var editUserName: EditText
    private lateinit var editUserAge: EditText
    private lateinit var addButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item, userList)
        listView.adapter = arrayAdapter
        viewModel =
            ViewModelProvider(this, UserViewModelFactory(userDao)).get(UserViewModel::class.java)
        viewModel.userLivedata.observe(this, Observer {
            userList.clear()
            userList.addAll(it)
            arrayAdapter.notifyDataSetChanged()
        })
        addButton.setOnClickListener {
            addClick()
        }
    }

    private fun init() {
        editUserName = findViewById(R.id.user_name)
        editUserAge = findViewById(R.id.user_age)
        addButton = findViewById(R.id.btn_add)
        listView = findViewById(R.id.recycler_view)
    }

    fun addClick() {
        if (editUserName.text.toString() == "" || editUserAge.text.toString() == "") {
            Toast.makeText(this, "姓名或年龄不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        val user = UserEntity(
            name = editUserName.text.toString(),
            age = editUserAge.text.toString().toInt()
        )
        thread {
            userDao.addUser(user)
        }
    }
}