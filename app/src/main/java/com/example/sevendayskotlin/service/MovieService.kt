package com.example.sevendayskotlin.service
import com.example.sevendayskotlin.model.Top250Data
import com.example.sevendayskotlin.webClient.IMDB_API_KEY
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET(IMDB_API_KEY)
    fun findTop250Movies(): Call<Top250Data>

}