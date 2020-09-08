package com.musaabshirgar.ktsearch.utils

object AppUtils {

    val Double?.precision: Double
        get() = String.format("%.5f", this ?: 0.0).toDouble()
}
