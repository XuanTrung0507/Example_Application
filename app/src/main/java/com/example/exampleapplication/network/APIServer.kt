package com.example.example.Network


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIServer {
    @POST("user/login/")
    fun loginUser(@Body loginUsers: LoginUsers): Call<CallApiDataLogin>

    @GET("user/me")
    fun getUserData(): Call<CallApiGetDataUser>

    @GET("collections/{collection_id}")
    fun getCollectionItem(@Path("collection_id") collection_id : String ): Call<ListItemProductCollection>

    @GET("collections/all")
    fun getAllCollection() : Call<ListCollection>
}

