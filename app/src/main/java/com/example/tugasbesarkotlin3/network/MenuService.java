package com.example.tugasbesarkotlin3.network;

import com.example.tugasbesarkotlin3.Models.MenuResult;
import retrofit2.Call;
import retrofit2.http.*;

public interface MenuService {
    @GET("menu/search/{product}")
    Call<MenuResult> getMenu(@Path("product") String product);
}
