package com.megamott.rl2_legengs.abstracts.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.abstracts.view_model.UserListViewModel
import java.lang.StringBuilder


class UserListFragment : Fragment() {
    private lateinit var currentQuestionTextView : TextView
    private val userListViewModel by viewModels<UserListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        currentQuestionTextView = view.findViewById(R.id.current_question)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListViewModel.queryUserList()
        userListViewModel.userListLiveData.observe(viewLifecycleOwner, {
            if (it != StringBuilder("")) {
                currentQuestionTextView.text = it
            }
        })
    }
}