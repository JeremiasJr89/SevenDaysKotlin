package com.example.sevendayskotlin.webClient

import com.example.sevendayskotlin.model.Movie
import com.example.sevendayskotlin.model.Top250Data
import com.example.sevendayskotlin.model.toMovie
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieWebClient {
    private val service = RetrofitInit().movieService

    fun findTop250Movies(onSuccess: (movies: List<Movie>) -> Unit) {
        service.findTop250Movies().enqueue(object : Callback<Top250Data?> {
            override fun onResponse(
                call: Call<Top250Data?>,
                response: Response<Top250Data?>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        val movies = data.items.map { detail ->
                            detail.toMovie()
                        }
                        onSuccess(movies)
                    }
                }
            }

            override fun onFailure(call: Call<Top250Data?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}