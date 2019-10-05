package com.example.exampleapplication.network

import com.example.example.data.StorageData
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers.single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://172.104.47.247:9922/api/v1/"

    fun getClient(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor{
                val request: Request = it.request()
                    .newBuilder()
                    .addHeader("Authorization", StorageData.instance.tokenUser.toString())
                    .build()
                return@Interceptor it.proceed(request)
                }
            )
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .writeTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build()

        val gson = GsonBuilder().setLenient().create()!!
        return Retrofit.Builder()
            .baseUrl(BASE_URL) //This is the onlt mandatory call on Builder object.
            .client(okHttpClient) //The Htttp client to be used for requests
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson)) // Convertor library used to convert response into POJO
            .build()
    }
}