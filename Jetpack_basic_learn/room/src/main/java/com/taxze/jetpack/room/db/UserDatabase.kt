package com.taxze.jetpack.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.taxze.jetpack.room.dao.UserDao
import com.taxze.jetpack.room.entity.UserEntity

@Database(entities = [UserEntity::class], version = 2)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    companion object {
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    """
                    create table userScore(
                    id integer primary key autoincrement not null,
                    userScore integer not null)
                """.trimIndent()
                )
            }
        }

        @Volatile
        private var INSTANCE: UserDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): UserDatabase {


            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            //锁
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "userDb"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
