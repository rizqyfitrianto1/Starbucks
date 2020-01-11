package com.example.tugasbesarkotlin3.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Menu {
	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("product")
	@Expose
	private String product;
	@SerializedName("price")
	@Expose
	private String price;

	public String getImage() {
		return image;
	}

	public String getProduct() {
		return product;
	}

	public String getPrice() {
		return price;
	}
}