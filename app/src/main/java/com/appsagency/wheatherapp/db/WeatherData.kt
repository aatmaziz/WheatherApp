package com.appsagency.wheatherapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "weatherData")
data class WeatherData(

    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "humidity") var humidity: Int,
    @ColumnInfo(name = "temp_c") var tempInC: Double,
    @ColumnInfo(name = "temp_f") var tempInF: Double,
    @ColumnInfo(name = "lat") var lat: Double,
    @ColumnInfo(name = "lon") var lon: Double,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "region") var region: String,
    @Ignore @ColumnInfo(name = "cloud") var cloud: String
){

    constructor():this(null,0,0.0,0.0,0.0,0.0,"","","")
}