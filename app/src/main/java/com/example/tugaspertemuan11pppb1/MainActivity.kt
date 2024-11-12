package com.example.tugaspertemuan11pppb1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan11pppb1.adapter.UserAdapter
import com.example.tugaspertemuan11pppb1.model.UserResponse
import com.example.tugaspertemuan11pppb1.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private var Nothing?.layoutManager: LinearLayoutManager
    get() {}
    set(value) {}
private var Nothing?.adapter: UserAdapter
    get() {}
    set(value) {}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = null
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchUsers()
    }

    private fun fetchUsers() {
        RetrofitInstance.api.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.data ?: emptyList()
                    val recyclerView = null
                    recyclerView.adapter = UserAdapter(this@MainActivity, users)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed to fetch users", t)
            }
        })
    }
}
