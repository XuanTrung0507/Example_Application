package com.example.example.Network

import com.example.example.data.ExConstants

object CallAPI {
    fun create(): APIServer? {
        return RetrofitClients.getClient(ExConstants.URL)?.create(APIServer::class.java)
    }
}