package com.example.tugasbesarkotlin3.Paging

import com.google.gson.annotations.SerializedName

data class Response (

    @field:SerializedName("pesan")
    val pesan: String? = null,

    @field:SerializedName("menu")
    val menu: List<Menu>
)