package com.example.task.di

import com.example.task.domain.usecases.freshproducs.UsersUseCase
import com.example.task.domain.usecases.freshproducs.UsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCasesModule {

    @Singleton
    @Binds
    abstract fun provideUsersUseCase(
        usersUseCaseImpl: UsersUseCaseImpl
    ): UsersUseCase

}