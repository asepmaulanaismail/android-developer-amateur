package com.asepmaulanaismail.dicoding.androidamateur.barvolume

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val STATE_RESULT = "state_result"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)
        if (savedInstanceState != null){
            val result:String? = savedInstanceState.getString(STATE_RESULT)
            tv_result.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(STATE_RESULT, tv_result.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            val inputLength:String = edt_length.text.toString().trim()
            val inputWidth:String = edt_width.text.toString().trim()
            val inputHeight:String = edt_height.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true
                edt_length.error = "Field ini tidak boleh kosong"
            }

            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true
                edt_width.error = "Field ini tidak boleh kosong"
            }

            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true
                edt_height.error = "Field ini tidak boleh kosong"
            }

            val length:Double? = toDouble(inputLength)
            val width:Double? = toDouble(inputWidth)
            val height:Double? = toDouble(inputHeight)

            if (length == null){
                isInvalidDouble = true
                edt_length.error = "Field ini tidak boleh kosong"
            }

            if (width == null){
                isInvalidDouble = true
                edt_width.error = "Field ini tidak boleh kosong"
            }

            if (height == null){
                isInvalidDouble = true
                edt_height.error = "Field ini tidak boleh kosong"
            }

            if (!isInvalidDouble && !isEmptyFields){
                val volume:Double = length!! * width!! * height!!
                tv_result.text = volume.toString()
            }
        }
    }

    private fun toDouble(str: String): Double? {
        try {
            return java.lang.Double.valueOf(str)
        } catch (e: NumberFormatException) {
            return null
        }
    }
}
