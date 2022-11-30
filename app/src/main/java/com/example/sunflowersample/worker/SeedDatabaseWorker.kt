package com.example.sunflowersample.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.sunflowersample.data.AppDatabase
import com.example.sunflowersample.data.Plant
import com.example.sunflowersample.utilities.ALog
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams)   {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            ALog.d("TEST doWork")
            val fileName = inputData.getString(KEY_FILENAME)
            if (fileName != null) {
                applicationContext.assets.open(fileName).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val plantType = object : TypeToken<List<Plant>>() {}.type
                        val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.plantDao().insertAll(plantList)

                        Result.success()
                    }
                }
            } else {
                Result.failure()
            }
        } catch (exception: Exception) {
            ALog.e("Error seeding database")
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "PLANT_DATA_FILENAME"
    }
}