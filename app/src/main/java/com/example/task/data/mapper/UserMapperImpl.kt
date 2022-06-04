package com.example.task.data.mapper

import com.example.task.data.api.model.AlbumResponse
import com.example.task.data.api.model.AlbumPhotoResponse
import com.example.task.data.api.model.UserResponse
import com.example.task.domain.entity.Album
import com.example.task.domain.entity.AlbumPhoto
import com.example.task.domain.entity.User
import javax.inject.Inject

class UserMapperImpl @Inject constructor() : UserMapper {

    override fun mapUserToViewState(userResponse: UserResponse): User {

        return User(
            userResponse.id,
            userResponse.name,
            "${userResponse.address.city}, ${userResponse.address.suite}, ${userResponse.address.street}, ${userResponse.address.zipcode}"
        )
    }

    override fun mapAlbumToViewState(albumsResponse: List<AlbumResponse>): List<Album> {
        return albumsResponse.map {
            with(it) {
                Album(id, title)
            }
        }
    }

    override fun mapAlbumPhotosToViewState(albumPhotoResponse: List<AlbumPhotoResponse>): List<AlbumPhoto> {
        return albumPhotoResponse.map {
            with(it) {
                AlbumPhoto(id, url)
            }
        }
    }
}
