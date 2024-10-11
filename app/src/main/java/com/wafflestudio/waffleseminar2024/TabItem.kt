package com.wafflestudio.waffleseminar2024

import androidx.fragment.app.Fragment

data class TabItem(
    val title: String,
    val iconResId: Int,
    val fragmentProvider: () -> Fragment
)