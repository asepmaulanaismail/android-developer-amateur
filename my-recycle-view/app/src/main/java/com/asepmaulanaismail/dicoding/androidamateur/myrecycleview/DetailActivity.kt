package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val bundle = intent.getBundleExtra(MainActivity.BUNDLE)
        val twiceMember = bundle.getParcelable(MainActivity.MEMBER) as TwiceMember
        if (twiceMember == null){
            finish()
        }else{
            setToLayout(twiceMember)
        }
    }

    private fun setToLayout(twiceMember: TwiceMember){
        supportActionBar?.title = twiceMember.name
        Glide.with(this)
            .load(twiceMember.photo)
            .apply(RequestOptions().override(350, 550))
            .into(img_item_photo)

        tv_item_name.text = twiceMember.name
        tv_item_remarks.text = twiceMember.remarks
        tv_description.text = twiceMember.description
        tv_dob.text = twiceMember.dob
        tv_citizen.text = twiceMember.citizen
        tv_country.text = twiceMember.country
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
