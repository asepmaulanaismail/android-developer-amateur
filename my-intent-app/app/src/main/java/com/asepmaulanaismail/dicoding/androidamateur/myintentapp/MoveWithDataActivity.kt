package com.asepmaulanaismail.dicoding.androidamateur.myintentapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_data.*
import android.R.attr.name



class MoveWithDataActivity : AppCompatActivity() {
    companion object {
        val EXTRA_AGE = "extra_age"
        val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val name = intent.extras?.getString(EXTRA_NAME)
        val age = intent.extras?.getInt(EXTRA_AGE)
        val text = "Name : $name,\nYour Age : $age"
        tv_data_received.text = text
    }
}
