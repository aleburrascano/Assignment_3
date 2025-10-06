package com.example.assignment_3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    val name: String,
    val amount: Double,
    val unit: String
) : Parcelable
