package com.wafflestudio.waffleseminar2024.search

sealed class SearchItem {
    data class Label(val name: String): SearchItem()
    data class GenreButton(val name: String, val iconResId: Int): SearchItem()
}