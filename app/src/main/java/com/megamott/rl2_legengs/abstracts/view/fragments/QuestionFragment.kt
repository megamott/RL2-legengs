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
import com.megamott.rl2_legengs.abstracts.entity.Question
import com.megamott.rl2_legengs.abstracts.view_model.QuestionViewModel

class QuestionFragment : Fragment() {
    private lateinit var answerButton: Button
    private lateinit var questionTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewOfLayout = inflater.inflate(R.layout.fragment_question, container, false)

        answerButton = viewOfLayout.findViewById(R.id.answer_button)!! // TODO What's after?: ?
        questionTextView = viewOfLayout.findViewById(R.id.question)!! // TODO What's after?: ?

        answerButton.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return viewOfLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionViewModel: QuestionViewModel =
            ViewModelProvider(this).get(QuestionViewModel::class.java)
        val questions: LiveData<ArrayList<Question>> = questionViewModel.getQuestions()
        questions.observe(this, {
            questionTextView.text = it[0].qText
        })
    }
}