package com.example.pictures.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "plants")
data class Pictures(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NotNull
    var id: Int,
    var copyright: String?,
    var date: String,
    var explanation: String,
    var hdurl: String,
    var media_type: String,
    var service_version: String,
    var title: String,
    var url: String
){
    override fun toString() = title
}