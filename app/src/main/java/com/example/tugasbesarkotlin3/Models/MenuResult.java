package com.example.tugasbesarkotlin3.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuResult {
	@SerializedName("menu")
	@Expose
	private List<Menu> menus = null;

	public List<Menu> getMenus() {
		return menus;
	}
}