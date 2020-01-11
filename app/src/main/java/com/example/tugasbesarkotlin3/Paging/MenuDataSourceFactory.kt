package com.example.tugasbesarkotlin3.Paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.tugasbesarkotlin3.Paging.Menu
import io.reactivex.disposables.CompositeDisposable

class MenuDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: NetworkService)
    : DataSource.Factory<Int, Menu>() {

    val newsDataSourceLiveData = MutableLiveData<MenuDataSource>()

    override fun create(): DataSource<Int, Menu> {
        val newsDataSource = MenuDataSource(networkService, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}