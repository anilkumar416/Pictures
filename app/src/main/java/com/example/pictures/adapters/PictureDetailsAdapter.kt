package com.example.pictures.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pictures.databinding.ListItemPictureDetailsBinding
import com.example.pictures.db.Pictures
import com.example.pictures.diffutil.PictureDiffUtil

class PictureDetailsAdapter :
    ListAdapter<Pictures, RecyclerView.ViewHolder>(PictureDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PictureDetailsViewHolder(
            ListItemPictureDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class PictureDetailsViewHolder(
        private val binding: ListItemPictureDetailsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pictures) {
            binding.apply {
                picture = item
                executePendingBindings()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val picture = getItem(position)
        (holder as PictureDetailsViewHolder).bind(picture)
    }
}


