package com.example.tugaspertemuan11pppb1.network

import com.example.tugaspertemuan11pppb1.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Mendefinisikan endpoint untuk mengambil daftar pengguna
    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<UserResponse>
}