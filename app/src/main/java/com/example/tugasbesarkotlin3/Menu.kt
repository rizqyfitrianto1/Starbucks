package com.example.tugasbesarkotlin3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasbesarkotlin3.Adapter.RecyclerAdapter
import com.example.tugasbesarkotlin3.Models.MenuResult
import com.example.tugasbesarkotlin3.network.ApiClient
import com.example.tugasbesarkotlin3.network.MenuService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Menu : AppCompatActivity() {

    internal var product = ""
    private var mRecyclerView: RecyclerView? = null
    private var recyclerAdapter: RecyclerAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        mRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        mLayoutManager = GridLayoutManager(applicationContext,2)
        mRecyclerView!!.layoutManager = mLayoutManager

//        val edtSearch = findViewById<EditText>(R.id.edt_search)
//        edtSearch.addTextChangedListener(object : TextWatcher {
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                product = edtSearch.text.toString().trim { it <= ' ' }
//                loadMenu(product)
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable) {
//
//            }
//        })

        loadMenu("")
    }

    private fun loadMenu(product: String) {
        val service = ApiClient.getRetrofit().create(MenuService::class.java)
        val menus = service.getMenu(product)
        menus.enqueue(object : Callback<MenuResult> {
            override fun onResponse(call: Call<MenuResult>, response: Response<MenuResult>) {

                val MenuList = response.body()!!.menus
                Log.d("Retrofit Get", "Jumlah data Kontak: " + MenuList.size.toString())
                recyclerAdapter = RecyclerAdapter(MenuList)
                mRecyclerView?.adapter = recyclerAdapter

            }

            override fun onFailure(call: Call<MenuResult>, t: Throwable) {
                Log.e("Retrofit Get", t.toString())
            }
        })
    }
}
