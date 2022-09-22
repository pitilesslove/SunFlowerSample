package com.example.sunflowersample.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Singleton

@Singleton
class PlantRepository() {

    private val plantDao = PlantDao()

    fun getPlants() : Flow<List<String>> = flowOf(plantDao.getPlants())

    fun getPlant(plantId: String) = flowOf(plantDao.getPlant(plantId))

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) : Flow<List<String>> =
        flowOf(plantDao.getPlantsWithGrowZoneNumber(growZoneNumber))

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao) =
            instance ?: synchronized(this) {
                instance ?: PlantRepository().also { instance = it }
            }
    }
}