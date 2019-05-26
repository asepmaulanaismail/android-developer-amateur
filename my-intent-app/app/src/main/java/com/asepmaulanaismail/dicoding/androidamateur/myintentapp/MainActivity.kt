package com.asepmaulanaismail.dicoding.androidamateur.myintentapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move_activity.setOnClickListener(this)
        btn_move_activity_data.setOnClickListener(this)
        btn_move_activity_object.setOnClickListener(this)
        btn_dial_number.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Asep")
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_object -> {
                Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "087821194312"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}
