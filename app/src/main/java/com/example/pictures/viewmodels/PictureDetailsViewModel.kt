package com.example.pictures.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pictures.repository.PicturesRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class PictureDetailsViewModel @AssistedInject constructor(
    picturesRepository: PicturesRepository,
    @Assisted private val pictureId: Int
) : ViewModel() {

    val pictureDetails = picturesRepository.getPicture(pictureId)

    val pictureList = picturesRepository.getPictures()

    @AssistedInject.Factory
    interface AssistedFactory {
        fun create(pictureId: Int): PictureDetailsViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: AssistedFactory,
            pictureId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(pictureId) as T
            }
        }
    }

}