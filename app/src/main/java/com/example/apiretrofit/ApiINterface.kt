package com.example.apiretrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiINterface {

    @GET("/gimme")
    fun getData():Call<responseDataClass>

}

https://www.youtube.com/watch?v=E8OXH0sMqEw
chadhuvuko