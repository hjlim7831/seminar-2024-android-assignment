package com.wafflestudio.waffleseminar2024.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wafflestudio.waffleseminar2024.databinding.TabSearchViewBinding
import kotlinx.serialization.json.Json

class SearchFragment: Fragment() {

    private var _binding: TabSearchViewBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SearchFragment", parseMovieGenres().toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = TabSearchViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun parseMovieGenres(): GenreDTO {
        return Json.decodeFromString(movieGenres)
    }
}

val movieGenres = """
    {
      "genres": [
        {
          "id": 28,
          "name": "액션"
        },
        {
          "id": 12,
          "name": "모험"
        },
        {
          "id": 16,
          "name": "애니메이션"
        },
        {
          "id": 35,
          "name": "코미디"
        },
        {
          "id": 80,
          "name": "범죄"
        },
        {
          "id": 99,
          "name": "다큐멘터리"
        },
        {
          "id": 18,
          "name": "드라마"
        },
        {
          "id": 10751,
          "name": "가족"
        },
        {
          "id": 14,
          "name": "판타지"
        },
        {
          "id": 36,
          "name": "역사"
        },
        {
          "id": 27,
          "name": "공포"
        },
        {
          "id": 10402,
          "name": "음악"
        },
        {
          "id": 9648,
          "name": "미스터리"
        },
        {
          "id": 10749,
          "name": "로맨스"
        },
        {
          "id": 878,
          "name": "SF"
        },
        {
          "id": 10770,
          "name": "TV 영화"
        },
        {
          "id": 53,
          "name": "스릴러"
        },
        {
          "id": 10752,
          "name": "전쟁"
        },
        {
          "id": 37,
          "name": "서부"
        }
      ]
    }
    
""".trimIndent()