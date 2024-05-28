package com.alvarogomez.acapplication.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.alvarogomez.acapplication.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            Glide.with(cover).load("https://image.tmdb.org/t/p/w500/${args.movie.backdrop_path}").into(cover)
            tvInfoMovie.text = buildSpannedString {
                bold { append(("Name: ")) }
                appendLine(args.movie.title)
                bold { append(("Overview: ")) }
                appendLine(args.movie.overview)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}