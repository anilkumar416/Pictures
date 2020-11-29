package com.example.pictures.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pictures.db.Pictures
import com.example.pictures.repository.PicturesRepository

class PicturesListViewModel @ViewModelInject internal constructor(
    picturesRepository: PicturesRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val pictureList: LiveData<List<Pictures>> = picturesRepository.getPictures()


}