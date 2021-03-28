package com.megamott.rl2_legengs.abstracts.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.megamott.rl2_legengs.R


class UserListFragment : Fragment() {

    private lateinit var addQuestionEditor : EditText
    private lateinit var addQuestionButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        addQuestionButton = view.findViewById(R.id.add_question_button)
        addQuestionEditor = view.findViewById(R.id.add_question_editor)

        return view
    }
}