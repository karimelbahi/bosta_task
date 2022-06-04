package com.example.task.domain.usecases.freshproducs

import android.util.Log
import com.example.task.domain.repo.UsersRepo
import com.example.task.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UsersUseCaseImpl @Inject constructor(
    private val repository: UsersRepo
) : UsersUseCase {

    override fun getUser(userId: Int): Flow<Resource<*>> {
        return repository.getUser(userId)
    }

    override fun getUserAlbums(userId: Int): Flow<Resource<*>> {
        return repository.getUserAlbums(userId)
    }

    override fun getAlbumPhotos(albumId: Int): Flow<Resource<*>> {
        return repository.getAlbumPhotos(albumId)
    }


}