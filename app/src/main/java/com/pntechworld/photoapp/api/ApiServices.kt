package com.pntechworld.photoapp.api

import com.pntechworld.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("?key=8278506-406dc46ffa3c8fe28db145ee2&q=animal&image_type=photo")
    fun getPhotos(): Call<PhotoList>
}