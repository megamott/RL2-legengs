package com.megamott.rl2_legengs.abstracts.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.abstracts.entity.User
import kotlinx.android.synthetic.main.user_in_list.view.*

class UserListAdapter(private val context: Context?) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var userList: MutableList<User> = ArrayList()

    fun addItems(list: MutableList<User>) {
        userList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if (userList.size == 0) {
            Log.d("Empty list", "User list in recycler is empty!")
        }
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(context)
        val root = inflater.inflate(R.layout.user_in_list, parent, false)
        return UserViewHolder(root)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    class UserViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.user_list_element.text = user.name
        }
    }
}