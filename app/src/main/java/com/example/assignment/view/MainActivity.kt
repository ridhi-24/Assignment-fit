package com.example.assignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.repository.MainRepository
import com.example.assignment.MovieAdapter
import com.example.assignment.`interface`.onclickInterface
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.model.Movie
import com.example.assignment.network.RetrofitService
import com.example.assignment.viewmodel.MainViewModel
import com.example.assignment.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity(),onclickInterface {

    lateinit var viewModel: MainViewModel
    private val adapter = MovieAdapter(this)
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)


        viewModel.movieList.observe(this, {
            adapter.setMovies(it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()

    }

    override fun setClick(data: Movie) {

    }

}