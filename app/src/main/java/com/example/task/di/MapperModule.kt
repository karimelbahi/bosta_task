package com.example.task.di

import com.example.task.data.mapper.UserMapper
import com.example.task.data.mapper.UserMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Singleton
    @Binds
    abstract fun provideUserMapper(userMapperImpl: UserMapperImpl): UserMapper

}