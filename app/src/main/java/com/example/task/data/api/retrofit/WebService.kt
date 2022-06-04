package com.example.task.data.api.retrofit


import com.example.task.data.api.model.AlbumResponse
import com.example.task.data.api.model.AlbumPhotoResponse
import com.example.task.data.api.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("albums")
    suspend fun getUserAlbums(@Query("userId") userId: Int):  List<AlbumResponse>

    @GET("photos")
    suspend fun getAlbumPhotos(@Query("albumId") albumId: Int):  List<AlbumPhotoResponse>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): UserResponse

}