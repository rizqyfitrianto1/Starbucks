package com.example.tugasbesarkotlin3.Paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasbesarkotlin3.Paging.Menu
import com.example.tugasbesarkotlin3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(menu: Menu?){
        if (menu != null){
            itemView.tv_product.text = menu.product
            itemView.tv_price.text = "Rp " + menu.price
            Picasso.get().load(menu.image).into(itemView.img_product)
        }
    }
    companion object{
        fun create(parent: ViewGroup): MenuViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)

            return MenuViewHolder(view)

        }
    }
}