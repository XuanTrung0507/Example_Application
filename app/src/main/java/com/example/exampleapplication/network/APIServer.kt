package com.example.example.Network


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIServer {
    @POST("user/login/")
    fun loginUser(@Body loginUsers: LoginUsers): Call<CallApiDataLogin>

    @GET("user/me")
    fun getUserData(): Call<CallApiGetDataUser>
}
