package com.example.tugaspertemuan11pppb1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan11pppb1.R
import com.example.tugaspertemuan11pppb1.model.User
import com.example.tugaspertemuan11pppb1.ui.DetailActivity
import com.squareup.picasso.Picasso

private val View.userEmail: Any
    get() {}
private var Any.text: String
    get() {}
    set(value) {}
private val View.userAvatar: Any
    get() {}
private val View.userName: Any
    get() {}

class UserAdapter(
    private val context: Context,
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: User) {
            itemView.userName.text = "${user.first_name} ${user.last_name}"
            itemView.userEmail.text = user.email
            Picasso.get().load(user.avatar).into(itemView.userAvatar)

            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("user", user)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}