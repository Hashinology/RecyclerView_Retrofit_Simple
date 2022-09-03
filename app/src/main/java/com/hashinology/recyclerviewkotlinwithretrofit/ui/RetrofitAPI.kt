package com.hashinology.recyclerviewkotlinwithretrofit.ui


import com.hashinology.recyclerviewkotlinwithretrofit.models.ModelList
import retrofit2.http.GET

interface RetrofitAPI {
    companion object{
        const val Base_URL = "https://api.genderize.io/?name=luc/"
    }

    @GET(Base_URL)
    fun getRetrofitInterfaceMethod(): retrofit2.Call<ModelList>
}
