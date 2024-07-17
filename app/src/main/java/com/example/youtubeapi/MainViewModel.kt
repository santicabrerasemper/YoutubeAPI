package com.example.youtubeapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeapi.response.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var _videosList = MutableLiveData<List<Item>>()
    val videosList: LiveData<List<Item>> get() = _videosList

    fun getVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getVideos()
            withContext(Dispatchers.Main) {
                _videosList.value = response.body()!!.items
            }
        }
    }

}