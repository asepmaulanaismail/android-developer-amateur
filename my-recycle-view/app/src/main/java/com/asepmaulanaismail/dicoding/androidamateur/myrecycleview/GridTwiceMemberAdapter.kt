package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_grid_president.view.*

class GridTwiceMemberAdapter(private val context: Context?) : RecyclerView.Adapter<GridTwiceMemberAdapter.CategoryViewHolder>(){

    private var listTwiceMember: ArrayList<TwiceMember>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): GridTwiceMemberAdapter.CategoryViewHolder {
        val itemRow = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_president, viewGroup, false)
        return CategoryViewHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return listTwiceMember!!.size
    }

    override fun onBindViewHolder(categoryViewHolder: GridTwiceMemberAdapter.CategoryViewHolder, position: Int) {
        Glide.with(context!!)
            .load(listTwiceMember?.get(position)?.photo)
            .apply(RequestOptions().override(350, 550))
            .into(categoryViewHolder.imgPhoto)
    }

    fun setListTwiceMember(listTwiceMember: ArrayList<TwiceMember>?){
        this.listTwiceMember = listTwiceMember
    }

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPhoto = itemView.img_item_photo
    }
}