package com.megamott.rl2_legengs.abstracts.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.abstracts.view.adapter.UserListAdapter
import com.megamott.rl2_legengs.abstracts.view_model.UserListViewModel


class UserListFragment : Fragment() {
    private lateinit var userListView : RecyclerView
    private lateinit var userListAdapter: UserListAdapter
    private val userListViewModel by viewModels<UserListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        userListView = view.findViewById(R.id.user_list_recycler)
        userListView.setHasFixedSize(true)
        userListView.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        userListAdapter = UserListAdapter(this.context)
        userListViewModel.userListLiveData.observe(viewLifecycleOwner, {
            if (it != null) {
                userListAdapter.addItems(it)
            }
        })

        userListView.adapter = userListAdapter

        return view
    }
}