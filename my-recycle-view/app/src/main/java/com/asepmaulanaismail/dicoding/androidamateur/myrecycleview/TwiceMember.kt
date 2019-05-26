package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview


import android.os.Parcelable
import android.os.Parcel

class TwiceMember: Parcelable {
    var name: String? = null
    var dob: String? = null
    var citizen: String? = null
    var country: String? = null

    var remarks: String? = null
    var description: String? = null
    var photo: String? = null

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.name)
        dest.writeString(this.dob)
        dest.writeString(this.citizen)
        dest.writeString(this.country)
        dest.writeString(this.remarks)
        dest.writeString(this.description)
        dest.writeString(this.photo)
    }

    constructor()
    private constructor(`in`: Parcel) {
        this.name = `in`.readString()
        this.dob = `in`.readString()
        this.citizen = `in`.readString()
        this.country = `in`.readString()
        this.remarks = `in`.readString()
        this.description = `in`.readString()
        this.photo = `in`.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TwiceMember> = object : Parcelable.Creator<TwiceMember> {
            override fun createFromParcel(source: Parcel): TwiceMember {
                return TwiceMember(source)
            }

            override fun newArray(size: Int): Array<TwiceMember>{
                return arrayOf()
            }
        }
    }
}