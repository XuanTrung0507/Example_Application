package com.example.example.Network

import android.util.Log
import android.widget.Toast
import com.example.example.data.StorageData
import com.example.example.data.ExConstants
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

object AuthenticateFunctions {

    private val retrofit = RetrofitClient.getClient()
    private val apiService: APIServer = retrofit.create()!!
    //private val apiService: APIServer = CallAPI.create()!!

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
                        Log.e("aaa",response.body()?.data?.token)
                    }
                    callback()
                } else {
                    Toast.makeText(activity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<CallApiDataLogin>, t: Throwable) {
                activity.dismissProgressLoading()
                Toast.makeText(activity, "Lỗi", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun callApiRegister(
        activity: BaseActivity, email: String, fullName: String, pwd: String, phone: String,
        username: String,
        callbackRegister: () -> Unit
    ) {
        activity.showProgressLoading()
        val callRegister:Call<DataUsers> = apiService.registerUser(
            RegisterUsers(
                email,
                fullName, pwd,
                phone,
                username
            )
        )
        callRegister.enqueue(object : Callback<DataUsers> {
            override fun onResponse(call: Call<DataUsers>, response: Response<DataUsers>) {
                activity.dismissProgressLoading()
                if (response.body()?.message == ExConstants.LOGIN_SUCCESS) {
                    callbackRegister()
                } else {
                    Toast.makeText(activity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<DataUsers>, t: Throwable) {
                Toast.makeText(activity, R.string.error_response, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun callApiGetUserData(callbackGetUser: (response: Response<CallApiGetDataUser>) -> Unit) {
        val dataUsers: Call<CallApiGetDataUser> = apiService.getUserData()
        dataUsers.enqueue(object : Callback<CallApiGetDataUser> {
            override fun onFailure(call: Call<CallApiGetDataUser>, t: Throwable) {
            }
            override fun onResponse(call: Call<CallApiGetDataUser>, response: Response<CallApiGetDataUser>) {
                callbackGetUser(response)
            }
        })
    }

    fun getItemProductCollection(
        activity: BaseActivity,
        collection_id : String,
        callBackGetItemProduct : (response : Response<ListItemProductCollection>) -> Unit)
    {
        activity.showProgressLoading()
        val  dataItemsProduct : Call<ListItemProductCollection> = CallAPI.create()!!.getCollectionItem(collection_id)
        dataItemsProduct.enqueue(object : Callback<ListItemProductCollection>{
            override fun onFailure(call: Call<ListItemProductCollection>, t: Throwable) {
                activity.dismissProgressLoading()
                Toast.makeText(activity,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ListItemProductCollection>, response: Response<ListItemProductCollection>) {
                activity.dismissProgressLoading()
                if (response.body()?.message == ExConstants.LOGIN_SUCCESS){
                    callBackGetItemProduct(response)
                }
                else{
                    Toast.makeText(activity,""+ response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
    fun getAllCollection(activity: BaseActivity, callBackGetAllCollection : (response : Response<ListCollection>) -> Unit){
        activity.showProgressLoading()
        val  dataAllCollection : Call<ListCollection> = CallAPI.create()!!.getAllCollection()
        dataAllCollection.enqueue(object  : Callback<ListCollection>{
            override fun onFailure(call: Call<ListCollection>, t: Throwable) {
                activity.dismissProgressLoading()
                Toast.makeText(activity,"Error",Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<ListCollection>, response: Response<ListCollection>) {
                activity.dismissProgressLoading()
                if(response.body()?.message == ExConstants.LOGIN_SUCCESS){
                    callBackGetAllCollection(response)
                }
                else{
                    Toast.makeText(activity,""+ response.message(), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}