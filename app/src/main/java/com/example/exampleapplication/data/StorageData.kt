package com.example.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.exampleapplication.BaseActivity

class StorageData {
    companion object {
        val instance by lazy { StorageData() }
    }
    var activity: BaseActivity? = null
    var tokenUser: String? = ""
        get() {
            val sharedPreferences = activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)
            return sharedPreferences?.getString(ExExtraKey.TOKEN,"")
        }
        set(value) {
            field = value
            activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE, Context.MODE_PRIVATE)?.edit()?.apply{
                putString(ExExtraKey.TOKEN,value)
                apply()
            }
        }

    var fullNameUser: String? = ""
        get() {
            val sharedPreferences = activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)
            return sharedPreferences?.getString(ExExtraKey.FULL_NAME,"")
        }
        set(value) {
            field = value
            activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE, Context.MODE_PRIVATE)?.edit()?.apply(){
                putString(ExExtraKey.FULL_NAME,field)
                apply()
            }
        }

    var phoneUser : String? = ""
        get() {
            val sharedPreferences = activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)
            return sharedPreferences?.getString(ExExtraKey.PHONE,"")
        }
        set(value) {
            field = value
            activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)?.edit()?.apply(){
                putString(ExExtraKey.PHONE,field)
                apply()
            }
        }

    var userName : String? = ""
        get() {
            val sharedPreferences = activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)
            return sharedPreferences?.getString(ExExtraKey.USER_NAME,"")
        }
        set(value) {
            field = value
            activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)?.edit()?.apply(){
                putString(ExExtraKey.USER_NAME,field)
                apply()
            }
        }

    var email : String? = ""
        get() {
            val sharedPreferences = activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)
            return sharedPreferences?.getString(ExExtraKey.EMAIL,"")
        }
        set(value) {
            field = value
            activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE,Context.MODE_PRIVATE)?.edit()?.apply(){
                putString(ExExtraKey.EMAIL,field)
                apply()
            }
        }


    fun logOutUser(){
        activity?.getSharedPreferences(ExConstants.Ex_SHARED_PREFERENCE, Context.MODE_PRIVATE)?.edit()?.apply {
            clear()
            apply()
        }
    }
}