package com.example.tmdbapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tmdbapp.data.adapters.MainAdapter
import com.example.tmdbapp.data.api.models.TmdbResultsDTO
import com.example.tmdbapp.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.tmdbInfo.observe(viewLifecycleOwner, Observer {
//            binding.mainRv.apply{
//                layoutManager = GridLayoutManager(requireContext(),2)
//                adapter = MainAdapter(it.results)

                binding.mainRv.adapter = MainAdapter(this@MainFragment::onFilmClick, viewModel.tmdbInfo.value?.results)
//                view.findViewById<Button>(R.id.search_button).setOnClickListener {
//                    findNavController().navigate(R.id.action_MainFragment_to_InfoFragment)
//                }
//            }
        })


    }
    private fun onFilmClick(film: TmdbResultsDTO?){
        if (film != null) {
            viewModel.filmTitle = "Title: ${film.title}"
            viewModel.filmPosterPath = film.posterPath
            viewModel.filmOverview = "OverView: ${film.overview}"
            viewModel.filmReleaseDate = "Release Date: ${film.releaseDate}"
            viewModel.filmPopularity = "Popularity: ${film.popularity.toString()}"
            viewModel.filmVoteAverage = "Vote Average: ${film.voteAverage.toString()}"
            viewModel.filmVoteCount = "Vote Count: ${film.voteCount.toString()}"
            findNavController().navigate(R.id.action_MainFragment_to_InfoFragment)
        }
    }
}