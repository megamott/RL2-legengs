package com.megamott.rl2_legengs.abstracts.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.abstracts.util.initFirebase
import com.megamott.rl2_legengs.abstracts.view_model.UserListViewModel
import java.lang.StringBuilder


class UserListFragment : Fragment() {
    private lateinit var userListTextView : TextView
    private lateinit var userListButton : Button
    private val userListViewModel by viewModels<UserListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        userListTextView = view.findViewById(R.id.user_list_text_view)
        userListButton = view.findViewById(R.id.user_button)

        userListButton.setOnClickListener {
            userListViewModel.queryUserList()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListViewModel.userListLiveData.observe(viewLifecycleOwner, {
            if (it != null) {
                userListTextView.text = it.toString()
            }
        })
    }
}