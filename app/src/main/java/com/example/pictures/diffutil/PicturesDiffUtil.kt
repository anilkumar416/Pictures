package com.example.pictures.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.pictures.db.Pictures

class PictureDiffUtil : DiffUtil.ItemCallback<Pictures>() {
    override fun areItemsTheSame(oldItem: Pictures, newItem: Pictures): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pictures, newItem: Pictures): Boolean {
        return oldItem == newItem
    }
}