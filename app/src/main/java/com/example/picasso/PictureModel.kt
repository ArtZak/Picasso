package com.example.picasso

import com.google.gson.annotations.SerializedName


data class PictureModel (
    @SerializedName("albumId") var albumId : Int,
    @SerializedName("id") var id : Int,
    @SerializedName("title") var title : String,
    @SerializedName("url") var url : String,
    @SerializedName("thumbnailUrl") var thumbnailUrl : String
)

data class PostPictureModel(var title: String, var url: String)