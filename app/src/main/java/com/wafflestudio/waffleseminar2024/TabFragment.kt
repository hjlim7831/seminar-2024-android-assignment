package com.wafflestudio.waffleseminar2024

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wafflestudio.waffleseminar2024.databinding.TabMovieViewBinding
import com.wafflestudio.waffleseminar2024.search.GenreDTO
import com.wafflestudio.waffleseminar2024.search.SearchItem
import com.wafflestudio.waffleseminar2024.search.movieGenres
import kotlinx.serialization.json.Json

class AppFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_app_view, container, false)
    }
}

class MovieFragment: Fragment() {

    private var _binding: TabMovieViewBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = TabMovieViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun genreButtons(): List<SearchItem.GenreButton> {
        val genreDTO = Json.decodeFromString<GenreDTO>(movieGenres)
        return genreDTO.genres.map { genre ->
            SearchItem.GenreButton(genre.name, genre.id, getIconResId(genre.name))
        }
    }

    private fun getIconResId(genreName: String):Int {
        return when (genreName) {
            "액션" -> R.drawable.genre_icons_action
            "모험" -> R.drawable.genre_icons_adventure
            "애니메이션" -> R.drawable.genre_icons_animation
            "코미디" -> R.drawable.genre_icons_comedy
            "범죄" -> R.drawable.genre_icons_crime
            "다큐멘터리" -> R.drawable.genre_icons_documentary
            "드라마" -> R.drawable.genre_icons_drama
            "가족" -> R.drawable.genre_icons_family
            "판타지" -> R.drawable.genre_icons_fantasy
            "역사" -> R.drawable.genre_icons_history
            "공포" -> R.drawable.genre_icons_horror
            "음악" -> R.drawable.genre_icons_music
            "미스터리" -> R.drawable.genre_icons_mystery
            "SF" -> R.drawable.genre_icons_sf
            "TV 영화" -> R.drawable.genre_icons_tv
            "스릴러" -> R.drawable.genre_icons_thriller
            "전쟁" -> R.drawable.genre_icons_war
            "서부" -> R.drawable.genre_icons_western
            else -> R.drawable.movie_recorder
        }
    }
}