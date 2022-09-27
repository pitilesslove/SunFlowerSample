package com.example.sunflowersample.data

import android.content.Context

abstract class AppDatabase {
    abstract fun plantDao(): PlantDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return AppDatabaseImpl()
        }
    }
}

class AppDatabaseImpl : AppDatabase() {
    override fun plantDao(): PlantDao {
        return PlantDao()
    }
}