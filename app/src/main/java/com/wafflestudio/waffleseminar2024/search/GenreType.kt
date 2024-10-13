package com.wafflestudio.waffleseminar2024.search

import kotlinx.serialization.Serializable

@Serializable
data class GenreType(
    val id: Int,
    val name: String
)


@Serializable
data class GenreDTO(
    val genres: List<GenreType>
)