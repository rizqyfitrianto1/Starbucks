package com.example.tugasbesarkotlin2.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tugasbesarkotlin3.Models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

}
