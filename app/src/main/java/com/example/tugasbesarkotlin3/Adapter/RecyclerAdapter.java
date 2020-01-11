package com.example.tugasbesarkotlin3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tugasbesarkotlin3.Models.Menu;
import com.example.tugasbesarkotlin3.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    List<Menu> mMenuList;

    public RecyclerAdapter(List<Menu> MenuList){
        mMenuList = MenuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder,final int position) {
        holder.tv_product.setText(mMenuList.get(position).getProduct());
        holder.tv_price.setText("Rp " + mMenuList.get(position).getPrice());
        Picasso.get()
                .load("http://172.16.10.246/starbucks/"+mMenuList.get(position).getImage())
                .resize(200,200)
                .centerCrop()
                .into(holder.img_product);

    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_product, tv_price;
        public ImageView img_product;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_product = (TextView) itemView.findViewById(R.id.tv_product);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);

            img_product = (ImageView) itemView.findViewById(R.id.img_product);
        }
    }

}