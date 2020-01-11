package com.example.tugasbesarkotlin3.Paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.tugasbesarkotlin3.Paging.Menu
import io.reactivex.disposables.CompositeDisposable


class MenuListViewModel : ViewModel() {

    private val networkService = NetworkService.getService()
    var menuList: LiveData<PagedList<Menu>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val menuDataSourceFactory: MenuDataSourceFactory

    init {
        menuDataSourceFactory = MenuDataSourceFactory(compositeDisposable, networkService)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        menuList = LivePagedListBuilder<Int, Menu>(menuDataSourceFactory, config).build()
    }


    fun getState(): LiveData<State> = Transformations.switchMap<MenuDataSource,
            State>(menuDataSourceFactory.newsDataSourceLiveData, MenuDataSource::state)

    fun retry() {
        menuDataSourceFactory.newsDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return menuList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
