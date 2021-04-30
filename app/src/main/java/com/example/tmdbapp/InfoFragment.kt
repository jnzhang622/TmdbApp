package com.example.tmdbapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tmdbapp.databinding.InfoFragmentBinding

class InfoFragment : Fragment() {

    private var _binding: InfoFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = InfoFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        Glide.with(binding.infoFragmentIv)
            .load("https://image.tmdb.org/t/p/original${viewModel.filmPosterPath}")
            .into(binding.infoFragmentIv)

        binding.titleTv.text = viewModel.filmTitle
        binding.overviewTv.text = viewModel.filmOverview
        binding.releaseDateTv.text = viewModel.filmReleaseDate
        binding.popularityTv.text = viewModel.filmPopularity
        binding.voteAverageTv.text = viewModel.filmVoteAverage
        binding.voteCountTv.text = viewModel.filmVoteCount

        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            findNavController().navigate(R.id.action_InfoFragment_to_MainFragment)
        }
        view.findViewById<ImageView>(R.id.info_fragment_iv).setOnClickListener {
            findNavController().navigate(R.id.action_InfoFragment_to_MainFragment)
        }
    }
}