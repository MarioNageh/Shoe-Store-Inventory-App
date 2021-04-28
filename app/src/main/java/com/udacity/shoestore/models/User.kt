package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User(val email: String, val password: String): Parcelable {
    fun isUserExists(em: String, pass: String): Boolean {
        return (em == email && pass == password)
    }
}