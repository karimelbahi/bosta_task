package com.example.task.presentation.ui.profile

import androidx.lifecycle.*
import com.example.task.domain.entity.Album
import com.example.task.domain.entity.User
import com.example.task.domain.usecases.freshproducs.UsersUseCase
import com.example.task.presentation.utils.Resource
import com.example.task.presentation.utils.ResourcesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    private val _users = MutableLiveData<Resource<User>>()
    val users = _users as LiveData<Resource<User>>

    private val _usersAlbums = MutableLiveData<Resource<List<Album>>>()
    val usersAlbums = _usersAlbums as LiveData<Resource<List<Album>>>

    private val _randomUser = (1..10).random()


    fun getUserDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            _users.postValue(Resource.loading())
            val userInfoAsync = async { usersUseCase.getUser(_randomUser).first() }
            val userAlbumsAsync = async { usersUseCase.getUserAlbums(_randomUser).first() }
            _users.postValue(userInfoAsync.await() as Resource<User>)
            _usersAlbums.postValue(userAlbumsAsync.await() as Resource<List<Album>>)
        }
    }
}