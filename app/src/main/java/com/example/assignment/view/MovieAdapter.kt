package com.example.assignment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.*
import com.example.assignment.`interface`.onclickInterface
import com.example.assignment.databinding.AdapterMovieBinding
import com.example.assignment.model.Movie
import com.example.assignment.view.Detailactivity
import com.squareup.picasso.Picasso


class MovieAdapter(              private val cellClickListener: onclickInterface
) : RecyclerView.Adapter<MainViewHolder>(){

    var movieList = mutableListOf<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
        holder.binding.name.text = movie.title
        Picasso.get().load(movie.url).into(holder.binding.imageview);

        holder.binding.imageview.setOnClickListener {
          /*  val intent = Intent(this, Detailactivity::class.java)


            cellClickListener.setClick(movie.title)
*/
        }


    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}