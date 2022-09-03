package com.hashinology.recyclerviewkotlinwithretrofit

import com.hashinology.recyclerviewkotlinwithretrofit.ui.RetrofitAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    val instance: RetrofitClient? = null
    var retrofitAPI: RetrofitAPI? = null

    init{
        val retrofit = Retrofit.Builder().baseUrl(RetrofitAPI.Base_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    }
    fun getInstanceValue(): RetrofitClient{
        if (instance == null){
            return RetrofitClient()
        }else{
            return instance
        }
    }
}