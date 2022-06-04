package com.example.task.domain.repo

import com.example.task.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface UsersRepo {

    fun getUser(userId: Int): Flow<Resource<*>>
    fun getUserAlbums(userId: Int): Flow<Resource<*>>
    fun getAlbumPhotos(albumId: Int): Flow<Resource<*>>
}