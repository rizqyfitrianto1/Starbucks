package com.example.tugasbesarkotlin3.Paging

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("menu/search/")
    fun getNews(@Query("page")page :Int,
                @Query("pageSize") pageSize: Int) : Single<Response>


    companion object{
        fun getService(): NetworkService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://172.16.10.66/starbucks/public/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(NetworkService::class.java)
        }
    }
}