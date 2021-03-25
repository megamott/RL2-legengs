package com.megamott.rl2_legengs.abstracts.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.abstracts.view_model.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var textView: TextView
    private lateinit var countButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        textView = view.findViewById(R.id.count_text)
        countButton = view.findViewById(R.id.count_button)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mLoginViewModel: LoginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)
        val count: LiveData<Int> =
            mLoginViewModel.getInitialCount()  // get countLiveData from LoginViewModel
        count.observe(this, {  // observe on changes of countLiveData in LoginViewModel
            textView.text = "Counter: $it"
        })

        countButton.setOnClickListener {
            mLoginViewModel.setCurrentCount()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.login_container, QuestionFragment())
                ?.addToBackStack("question")
                ?.commit()
        }
    }
}