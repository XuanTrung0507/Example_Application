package com.example.example.Network

import android.util.Log
import android.widget.Toast
import com.example.example.data.StorageData
import com.example.example.data.ExConstants
import com.example.exampleapplication.BaseActivity
import com.example.exampleapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthenticateFunctions {
    private val apiService: APIServer = CallAPI.create()!!

    fun callApiLogin(activity: BaseActivity, email: String, pass: String, callback: () -> Unit) {
        activity.showProgressLoading()
        val callLoginUsers: Call<CallApiDataLogin> = apiService.loginUser(
            LoginUsers(
                email,
                pass
            )
        )
        callLoginUsers.enqueue(object : Callback<CallApiDataLogin> {
            override fun onResponse(call: Call<CallApiDataLogin>, response: Response<CallApiDataLogin>) {
                activity.dismissProgressLoading()
                if (response.body()?.message == ExConstants.LOGIN_SUCCESS) {
                    StorageData.instance.apply {
                        tokenUser = "Bearer ${response.body()?.data?.token}"
                        fullNameUser = response.body()?.data?.users?.getFullName
                    }
                    callback()
                } else {
                    Toast.makeText(activity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<CallApiDataLogin>, t: Throwable) {
                activity.dismissProgressLoading()
                Toast.makeText(activity, R.string.error_response, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun callApiGetUserData(callbackGetUser: (response: Response<CallApiGetDataUser>) -> Unit) {
        val dataUsers: Call<CallApiGetDataUser> = CallAPI.create()!!.getUserData()
        dataUsers.enqueue(object : Callback<CallApiGetDataUser> {
            override fun onFailure(call: Call<CallApiGetDataUser>, t: Throwable) {
            }
            override fun onResponse(call: Call<CallApiGetDataUser>, response: Response<CallApiGetDataUser>) {
                callbackGetUser(response)
            }
        })
    }
}