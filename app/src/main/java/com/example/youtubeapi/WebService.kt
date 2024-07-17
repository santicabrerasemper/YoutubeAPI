package com.example.youtubeapi

import com.example.youtubeapi.response.ResponseAPI
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("search?part=snippet&eventtype=live&q=music&type=video&key=AIzaSyApl1izlUEIkibPxKTe6laXJhgwd7imWyw")
    suspend fun getVideos() : Response<ResponseAPI>
}