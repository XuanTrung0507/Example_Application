package com.example.example.Network


import retrofit2.Call
import retrofit2.http.*

interface APIServer {
    @Headers("Content-Type: application/json; charset=UTF-8")
    @POST("user/register")
    fun registerUser(@Body registerUsers: RegisterUsers): Call<DataUsers>

    @POST("user/login/")
    fun loginUser(@Body loginUsers: LoginUsers): Call<CallApiDataLogin>

    @GET("user/me")
    fun getUserData(): Call<CallApiGetDataUser>

    @GET("collections/{collection_id}")
    fun getCollectionItem(@Path("collection_id") collection_id : String ): Call<ListItemProductCollection>

    @GET("collections/all")
    fun getAllCollection() : Call<ListCollection>
}

