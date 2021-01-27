package com.lgw.android.testmodule.aidl

import android.os.Parcel
import android.os.Parcelable

/**
 *Created by lgw on 1/25/21
 */
 class Book() :Parcelable {
    private var bookName:String?=null

    private var bookId:Int=0

    constructor(parcel: Parcel) : this() {
        bookName = parcel.readString()
        bookId = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bookName)
        parcel.writeInt(bookId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }


}