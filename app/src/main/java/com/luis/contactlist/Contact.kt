package com.luis.contactlist

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val phone: String,
    @DrawableRes val icon: Int
)
