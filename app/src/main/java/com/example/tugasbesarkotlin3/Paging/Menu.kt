package com.example.tugasbesarkotlin3.Paging

import com.google.gson.annotations.SerializedName

data class Menu(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("product")
    val product: String? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("price")
    val price: String? = null
)