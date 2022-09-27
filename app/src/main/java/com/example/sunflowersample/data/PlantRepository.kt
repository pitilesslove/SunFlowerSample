package com.example.sunflowersample.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantRepository @Inject constructor(private val plantDao: PlantDao) {

    fun getPlants(): Flow<List<Plant>> = plantDao.getPlants()

    fun getPlant(plantId: String): Flow<Plant> = plantDao.getPlant(plantId)

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>> =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)
}