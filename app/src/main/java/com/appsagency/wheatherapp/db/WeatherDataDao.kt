package com.appsagency.wheatherapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface WeatherDataDao {


    @Query("SELECT * from weatherData")
    fun getAllData(): List<WeatherData>


    @Insert(onConflict = REPLACE)
    fun insert(weatherData: WeatherData)


    @Query("DELETE from weatherData")
    fun deleteAll()


}