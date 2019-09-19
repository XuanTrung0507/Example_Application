package com.example.example.Network

import com.example.example.data.StorageData
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClients {
    companion object {
        var retrofit: Retrofit? = null

        private var okHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor {
                val request: Request = it.request().newBuilder().addHeader("Authorization",
                                                                            StorageData.instance.tokenUser.toString())
                                                                            .build()
                    return@Interceptor it.proceed(request)
            })
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .writeTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build()

        var gson = GsonBuilder().setLenient().create()!!

        fun getClient(baseURl: String) : Retrofit?{
            retrofit = Retrofit.Builder()
                .baseUrl(baseURl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit

        }
    }
}