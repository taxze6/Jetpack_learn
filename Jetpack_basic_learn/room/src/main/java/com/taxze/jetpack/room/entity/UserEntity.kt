package com.taxze.jetpack.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Score(
    val id: Int?,
    val score: String?,
)

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT) val name: String?,
    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER) val age: Int?,
)
