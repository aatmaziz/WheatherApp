package com.appsagency.wheatherapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appsagency.wheatherapp.utlis.SingletonHolder


@Database(entities = arrayOf(WeatherData::class), version = 1)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun WeatherDataDao(): WeatherDataDao

    companion object : SingletonHolder<WeatherDataBase, Context>({
        Room.databaseBuilder(
            it.applicationContext,
            WeatherDataBase::class.java, "weather.db"
        )
            .build()
    })

}