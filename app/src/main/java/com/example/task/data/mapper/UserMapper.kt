package com.example.task.data.mapper

import com.example.task.data.api.model.AlbumResponse
import com.example.task.data.api.model.AlbumPhotoResponse
import com.example.task.data.api.model.UserResponse
import com.example.task.domain.entity.Album
import com.example.task.domain.entity.AlbumPhoto
import com.example.task.domain.entity.User

interface UserMapper {

    fun mapUserToViewState(userResponse: UserResponse): User
    fun mapAlbumToViewState(albumsResponse: List<AlbumResponse>): List<Album>
    fun mapAlbumPhotosToViewState(albumPhotoResponse: List<AlbumPhotoResponse>): List<AlbumPhoto>

}