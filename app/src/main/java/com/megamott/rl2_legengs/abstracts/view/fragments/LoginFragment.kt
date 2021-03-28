package com.megamott.rl2_legengs.abstracts.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.UsersActivity
import com.megamott.rl2_legengs.abstracts.view_model.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var countButton: Button
    private lateinit var usersButton: Button
    private val mLoginViewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        textView = view.findViewById(R.id.count_text)
        countButton = view.findViewById(R.id.count_button)
        usersButton = view.findViewById(R.id.go_users_list)

        usersButton.setOnClickListener {
            activity?.let {
                val intent = Intent(it, UsersActivity::class.java)
                it.startActivity(intent)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val count: LiveData<Int> = mLoginViewModel.getInitialCount()
        count.observe(viewLifecycleOwner, {  // observe on changes of countLiveData in LoginViewModel
            textView.text = "Counter: $it"
        })

        countButton.setOnClickListener {
            mLoginViewModel.setCurrentCount()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.login_container, QuestionFragment())
                ?.commit()
        }
    }
}