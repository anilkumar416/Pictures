package com.example.pictures.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pictures.databinding.ListItemPicturesBinding
import com.example.pictures.db.Pictures
import com.example.pictures.diffutil.PictureDiffUtil
import com.example.pictures.ui.PicturesListFragmentDirections

class PicturesListAdapter :
    ListAdapter<Pictures, RecyclerView.ViewHolder>(PictureDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PictureViewHolder(
            ListItemPicturesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class PictureViewHolder(
        private val binding: ListItemPicturesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.picture?.let { picture ->
                    navigateToPicture(picture, it)
                }
            }
        }

        private fun navigateToPicture(picture: Pictures, view: View) {
            val direction =
                PicturesListFragmentDirections.actionPicturesListFragmentToPictureDetailsFragment(
                    picture.id
                )
            view.findNavController().navigate(direction)
        }

        fun bind(item: Pictures) {
            binding.apply {
                picture = item
                executePendingBindings()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val picture = getItem(position)
        (holder as PictureViewHolder).bind(picture)
    }
}

