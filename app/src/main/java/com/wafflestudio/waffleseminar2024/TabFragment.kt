package com.wafflestudio.waffleseminar2024

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wafflestudio.waffleseminar2024.databinding.TabMovieViewBinding
import com.wafflestudio.waffleseminar2024.search.GenreDTO
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

    private fun parseMovieGenres(): GenreDTO {
        return Json.decodeFromString(movieGenres)
    }
}