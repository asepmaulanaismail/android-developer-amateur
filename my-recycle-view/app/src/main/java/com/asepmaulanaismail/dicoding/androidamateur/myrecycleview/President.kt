package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

import android.os.Parcelable
import android.os.Parcel

class President: Parcelable {
    var name: String? = null
    var remarks: String? = null
    var photo: String? = null
    
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.name)
        dest.writeString(this.remarks)
        dest.writeString(this.photo)
    }

    constructor()
    private constructor(`in`: Parcel) {
        this.name = `in`.readString()
        this.remarks = `in`.readString()
        this.photo = `in`.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<President> = object : Parcelable.Creator<President> {
            override fun createFromParcel(source: Parcel): President {
                return President(source)
            }

            override fun newArray(size: Int): Array<President>{
                return arrayOf()
            }
        }
    }
}