package com.example.example.Network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginUsers(
    @SerializedName("email") @Expose var email: String,
    @SerializedName("password") @Expose var fullName: String
)

data class CallApiDataLogin(
    @SerializedName("code") @Expose var code: String,
    @SerializedName("message") @Expose var message: String,
    @SerializedName("data") @Expose var data: DataLogin
)

data class DataLogin(
    @SerializedName("token") @Expose var token: String,
    @SerializedName("user") @Expose var users: Users
)
data class CallApiGetDataUser(
    @SerializedName("code") @Expose var code: String,
    @SerializedName("message") @Expose var message: String,
    @SerializedName("data") @Expose var data: DataGetUser
)
data class DataGetUser(
    @SerializedName("user") @Expose var user: Users,
    @SerializedName("cards") @Expose var cards: List<DataCardsUser>
)

data class DataCardsUser(
    @SerializedName("card_number") @Expose var card_number:String,
    @SerializedName("balance") @Expose var balance:Float,
    @SerializedName("active") @Expose var getActive: Boolean
)


data class Users(
    @SerializedName("email") @Expose var getEmail: String,
    @SerializedName("full_name") @Expose var getFullName: String,
    @SerializedName("password") @Expose var getPwd: String,
    @SerializedName("phone") @Expose var getPhone: String,
    @SerializedName("referee_phone") @Expose var getRefereePhone: String,
    @SerializedName("username") @Expose var getUserName: String,
    @SerializedName("avatar") @Expose var getAvatar: String?,
    @SerializedName("total_point") @Expose var getTotalPoint: String,
    @SerializedName("total_exp") @Expose var getTotalExp: String
)
