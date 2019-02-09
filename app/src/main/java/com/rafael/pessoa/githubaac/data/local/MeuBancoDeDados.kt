package com.rafael.pessoa.githubaac.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.rafael.pessoa.githubaac.data.local.converter.DateConverter
import com.rafael.pessoa.githubaac.data.local.dao.UserDao
import com.rafael.pessoa.githubaac.data.local.entity.User

@Database(entities = [User::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MeuBancoDeDados: RoomDatabase(){


    abstract fun UserDao(): UserDao

    companion object {
      private val INSTANCE : MeuBancoDeDados? = null
    }

}