package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row_president.view.*

class ListTwiceMemberAdapter(private val context: Context?) : RecyclerView.Adapter<ListTwiceMemberAdapter.CategoryViewHolder>(){

    private var listTwiceMember: ArrayList<TwiceMember>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ListTwiceMemberAdapter.CategoryViewHolder {
        val itemRow = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_president, viewGroup, false)
        return CategoryViewHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return listTwiceMember!!.size
    }

    override fun onBindViewHolder(categoryViewHolder: ListTwiceMemberAdapter.CategoryViewHolder, position: Int) {
        categoryViewHolder.tvName.text = listTwiceMember?.get(position)?.name
        categoryViewHolder.tvRemarks.text = listTwiceMember?.get(position)?.remarks
        Glide.with(context!!)
            .load(listTwiceMember?.get(position)?.photo)
            .apply(RequestOptions().override(55, 55))
            .into(categoryViewHolder.imgPhoto)
    }

    fun setListTwiceMember(listTwiceMember: ArrayList<TwiceMember>?){
        this.listTwiceMember = listTwiceMember
    }

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.tv_item_name
        val tvRemarks = itemView.tv_item_remarks
        val imgPhoto = itemView.img_item_photo
    }
}