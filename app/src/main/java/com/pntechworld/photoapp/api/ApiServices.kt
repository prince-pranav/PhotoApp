package com.pntechworld.photoapp.api

import com.pntechworld.photoapp.models.Photo
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("?key=8278506-406dc46ffa3c8fe28db145ee2&q=animal&image-type=photo")
    fun gePhotos(): Call<Photo>


}