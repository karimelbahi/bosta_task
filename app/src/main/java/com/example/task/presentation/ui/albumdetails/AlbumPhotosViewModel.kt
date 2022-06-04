package com.example.task.presentation.ui.albumdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.domain.entity.AlbumPhoto
import com.example.task.domain.usecases.freshproducs.UsersUseCase
import com.example.task.presentation.utils.Resource
import com.example.task.presentation.utils.ResourcesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AlbumPhotosViewModel @Inject constructor(
    private val resourcesResolver: ResourcesResolver,
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    private val _usersAlbums = MutableLiveData<Resource<List<AlbumPhoto>>>()
    val usersAlbums = _usersAlbums as LiveData<Resource<List<AlbumPhoto>>>


    fun getUserDetails(albumId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _usersAlbums.postValue(Resource.loading())
            usersUseCase.getAlbumPhotos(albumId).first()
                .also { _usersAlbums.postValue(it as Resource<List<AlbumPhoto>>) }
        }

    }
}