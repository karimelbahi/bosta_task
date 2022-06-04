package com.example.task.di


import com.example.task.data.repo.UsersRepoImpl
import com.example.task.domain.repo.UsersRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getUsersRepo(repo: UsersRepoImpl): UsersRepo


}