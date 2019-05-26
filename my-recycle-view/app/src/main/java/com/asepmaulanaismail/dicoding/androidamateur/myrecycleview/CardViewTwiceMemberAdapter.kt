package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Toast
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_cardview_president.view.*

class CardViewTwiceMemberAdapter(private val context: Context?) : RecyclerView.Adapter<CardViewTwiceMemberAdapter.CategoryViewHolder>(){

    private var listTwiceMember: ArrayList<TwiceMember>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): CardViewTwiceMemberAdapter.CategoryViewHolder {
        val itemRow = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_cardview_president, viewGroup, false)
        return CategoryViewHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return listTwiceMember!!.size
    }

    override fun onBindViewHolder(categoryViewHolder: CardViewTwiceMemberAdapter.CategoryViewHolder, position: Int) {
        categoryViewHolder.tvName.text = listTwiceMember?.get(position)?.name
        categoryViewHolder.tvRemarks.text = listTwiceMember?.get(position)?.remarks
        Glide.with(context!!)
            .load(listTwiceMember?.get(position)?.photo)
            .apply(RequestOptions().override(350, 550))
            .into(categoryViewHolder.imgPhoto)
        categoryViewHolder.btnFavorite.setOnClickListener {
            Toast.makeText(context, "Favorite " +
                    getListTwiceMember()?.get(position)?.name, Toast.LENGTH_SHORT)
                .show()
        }
        categoryViewHolder.btnShare.setOnClickListener {
            Toast.makeText(context, "Share " +
                    getListTwiceMember()?.get(position)?.name, Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun setListTwiceMember(listTwiceMember: ArrayList<TwiceMember>?){
        this.listTwiceMember = listTwiceMember
    }

    fun getListTwiceMember(): ArrayList<TwiceMember>?{
        return this.listTwiceMember
    }

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.tv_item_name
        val tvRemarks = itemView.tv_item_remarks
        val imgPhoto = itemView.img_item_photo
        val btnFavorite = itemView.btn_set_favorite
        val btnShare = itemView.btn_set_share
    }
}