package com.example.assignment.repository

import com.example.assignment.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies() = retrofitService.getAllMovies()

}