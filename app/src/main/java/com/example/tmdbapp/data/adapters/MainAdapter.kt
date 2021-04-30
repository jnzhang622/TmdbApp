package com.example.tmdbapp.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbapp.data.api.models.TmdbResultsDTO
import com.example.tmdbapp.databinding.TmdbItemBinding

class MainAdapter(
    private val mListener: ((film: TmdbResultsDTO?) -> Unit), //needs to take in two arguments
    private val dataSet: List<TmdbResultsDTO>?) :
    RecyclerView.Adapter<MainAdapter.TmdbViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TmdbViewHolder =
        TmdbViewHolder(
            TmdbItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )


    override fun onBindViewHolder(viewHolder: TmdbViewHolder, position: Int) : Unit = with(viewHolder) {

        val singleFilm = dataSet?.get(position)
        loadData(singleFilm)
        viewHolder.itemView.setOnClickListener{mListener(singleFilm)}
    }

    override fun getItemCount() = dataSet?.size ?: 0

    class TmdbViewHolder(val binding: TmdbItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun loadData(singleFilm: TmdbResultsDTO?) = with(binding){

            if (singleFilm != null) {
                val posterUrl = "https://image.tmdb.org/t/p/original${singleFilm.posterPath}"
                Glide.with(filmPosterIv)
                    .load(posterUrl)
                    .into(filmPosterIv)

                binding.filmTitleTv.text = singleFilm.title
            }

        }
    }

}