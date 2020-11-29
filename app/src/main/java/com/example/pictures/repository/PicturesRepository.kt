package com.example.pictures.repository

import com.example.pictures.db.PicturesDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PicturesRepository @Inject constructor(private val picturesDao: PicturesDao) {

    fun getPictures() = picturesDao.getPlants()

    fun getPicture(pictureId: Int) = picturesDao.getPlant(pictureId)
}