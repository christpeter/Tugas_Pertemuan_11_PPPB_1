package com.example.tugaspertemuan11pppb1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan11pppb1.R
import com.example.tugaspertemuan11pppb1.model.User
import com.squareup.picasso.Picasso

private var Nothing?.text: String
    get() {}
    set(value) {}

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getSerializableExtra("user") as? User
        user?.let {
            val userName = null
            userName.text = "${it.first_name} ${it.last_name}"
            val userEmail = null
            userEmail.text = it.email
            val userAvatar = null
            Picasso.get().load(it.avatar).into(userAvatar)
        }
    }
}