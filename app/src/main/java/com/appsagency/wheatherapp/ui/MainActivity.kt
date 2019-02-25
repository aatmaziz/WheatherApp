package com.appsagency.wheatherapp.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsagency.wheatherapp.R
import com.appsagency.wheatherapp.db.WeatherData
import com.appsagency.wheatherapp.db.WeatherDataBase
import com.appsagency.wheatherapp.utlis.DbWorkerThread
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {


    private var mDb: WeatherDataBase? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mDbWorkerThread = DbWorkerThread(threadName = "dbWorkerThread")
        mDbWorkerThread.start()
        mDb = WeatherDataBase.getInstance(this)

        var weatherData = WeatherData(2, 3, 4.2, 2.1, 2.32, 231.1, "AzizDegree", "Mansoura", "heavy")

        insertWeatherDataInDb(weatherData)
        fetchWeatherDataFromDb()

    }


    private fun insertWeatherDataInDb(weatherData: WeatherData) {
        val task = Runnable { mDb?.WeatherDataDao()?.insert(weatherData) }
        mDbWorkerThread.postTask(task)
    }


    private fun fetchWeatherDataFromDb() {
        val task = Runnable {
            val weatherData = mDb?.WeatherDataDao()?.getAllData()
            mUiHandler.post {
                if (weatherData == null || weatherData?.size == 0) {
                    Toast.makeText(this, "No data in cache..!!", Toast.LENGTH_SHORT)
                } else {

                    Log.e("AzizData", weatherData?.size.toString())
                    Log.e("AzizData", Gson().toJson(weatherData))

                }
            }
        }
        mDbWorkerThread.postTask(task)

    }
}
