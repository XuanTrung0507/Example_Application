package com.example.example.Network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterUsers(
    @SerializedName("email") @Expose var email: String,
    @SerializedName("full_name") @Expose var fullName: String,
    @SerializedName("password") @Expose var pwd: String,
    @SerializedName("phone") @Expose var phone: String,
    @SerializedName("username") @Expose var userName: String
)

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
    @SerializedName("phone") @Expose var getPhone: String,
    @SerializedName("referee_phone") @Expose var getRefereePhone: String,
    @SerializedName("username") @Expose var getUserName: String,
    @SerializedName("avatar") @Expose var getAvatar: String?,
    @SerializedName("total_point") @Expose var getTotalPoint: String,
    @SerializedName("total_exp") @Expose var getTotalExp: String
)
data class DataProductCollection(
    @SerializedName("images") @Expose var images: List<DataImageProduct>,
    @SerializedName("name") @Expose var name: String,
    @SerializedName("price") @Expose var price: Double,
    @SerializedName("sale_price") @Expose var sale_price: Double?,
    @SerializedName("index") @Expose var index: Int
)
data class DataImageProduct(
    @SerializedName("index") @Expose var index: Int,
    @SerializedName("url") @Expose var url: String?
)
data class ListItemProductCollection(
    @SerializedName("code") @Expose var code: String,
    @SerializedName("message") @Expose var message: String,
    @SerializedName("data") @Expose var data: DataItemProductCollection
)
data class DataItemProductCollection(
    @SerializedName("products") @Expose var products: List<DataProductCollection>
)
data class DataCollectionGroup(
    @SerializedName("id") @Expose var id: String,
    @SerializedName("name") @Expose var name: String,
    @SerializedName("image") @Expose var image: ImageCollectionGroup
)
data class ImageCollectionGroup(
    @SerializedName("url") @Expose var url: String?
)
data class ListCollection(
    @SerializedName("code") @Expose var code: Int,
    @SerializedName("message") @Expose var message: String,
    @SerializedName("data") @Expose var data: List<DataCollectionGroup>
)
data class DataUsers(
    @SerializedName("code") @Expose var code: String,
    @SerializedName("message") @Expose var message: String,
    @SerializedName("data") @Expose var data: Data
)
data class Data(
    @SerializedName("token") @Expose var token: String?,
    @SerializedName("user") @Expose var users: Users?,
    @SerializedName("cards") @Expose var cards: MutableList<Cards>?
)
data class Cards(
    @SerializedName("card_number") @Expose var getCardsNumber: String,
    @SerializedName("balance") @Expose var getBalance: Int,
    @SerializedName("active") @Expose var getActive: Boolean
)