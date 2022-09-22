package com.example.sunflowersample.data

class PlantDao {
    private val plantDb = listOf<String>("Plant01", "Plant02")

    fun getPlants() = plantDb

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) = plantDb

    fun getPlant(plantId: String)  = plantDb.first()
}