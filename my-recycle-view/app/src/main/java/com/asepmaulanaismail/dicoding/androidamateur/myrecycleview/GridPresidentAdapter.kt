package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_grid_president.view.*

class GridPresidentAdapter(private val context: Context?) : RecyclerView.Adapter<GridPresidentAdapter.CategoryViewHolder>(){

    private var listPresident: ArrayList<President>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): GridPresidentAdapter.CategoryViewHolder {
        val itemRow = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_president, viewGroup, false)
        return CategoryViewHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return listPresident!!.size
    }

    override fun onBindViewHolder(categoryViewHolder: GridPresidentAdapter.CategoryViewHolder, position: Int) {
        Glide.with(context!!)
            .load(listPresident?.get(position)?.photo)
            .apply(RequestOptions().override(350, 550))
            .into(categoryViewHolder.imgPhoto)
    }

    fun setListPresident(listPresident: ArrayList<President>?){
        this.listPresident = listPresident
    }

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPhoto = itemView.img_item_photo
    }
}