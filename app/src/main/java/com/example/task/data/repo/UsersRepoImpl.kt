package com.example.task.data.repo

import com.example.task.data.api.model.AlbumPhotoResponse
import com.example.task.data.api.model.AlbumResponse
import com.example.task.data.api.model.UserResponse
import com.example.task.data.api.retrofit.WebService
import com.example.task.data.repo.base.BaseRepo
import com.example.task.domain.repo.UsersRepo
import com.example.task.data.mapper.UserMapper
import com.example.task.presentation.utils.Resource
import com.example.task.presentation.utils.Status
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepoImpl @Inject constructor(
    private val webService: WebService,
    private val userMapper: UserMapper
) : BaseRepo(),
    UsersRepo {

    override fun getUser(userId: Int) = loadFromApi {
        (webService::getUser)(userId)
    }.map {
        if (it.status.get() == Status.SUCCESS) {
            Resource.success(userMapper.mapUserToViewState(it.data as UserResponse))
        } else it
    }


    override fun getUserAlbums(userId: Int) = loadFromApi {
        (webService::getUserAlbums)(userId)
    }.map {
        if (it.status.get() == Status.SUCCESS) {
            Resource.success(userMapper.mapAlbumToViewState(it.data as List<AlbumResponse>))
        } else it
    }

    override fun getAlbumPhotos(albumId: Int) = loadFromApi {
        (webService::getAlbumPhotos)(albumId)
    }.map {
        if (it.status.get() == Status.SUCCESS) {
            Resource.success(userMapper.mapAlbumPhotosToViewState(it.data as List<AlbumPhotoResponse>))
        } else it
    }

}