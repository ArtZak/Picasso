package com.example.picasso

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface PictureApiService {


    @POST("photos")
    fun upload(@Body postPictureModel: PostPictureModel) : Call<PictureModel>
}

object PictureRetrofitService{
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}