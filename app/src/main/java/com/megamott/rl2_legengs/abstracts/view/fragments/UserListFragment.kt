package com.megamott.rl2_legengs.abstracts.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.megamott.rl2_legengs.R
import com.megamott.rl2_legengs.abstracts.entity.Question
import com.megamott.rl2_legengs.abstracts.util.*
import java.lang.StringBuilder


class UserListFragment : Fragment() {

    private lateinit var addQuestionEditor : EditText
    private lateinit var addQuestionButton : Button
    private lateinit var currentQuestionTextView : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        addQuestionButton = view.findViewById(R.id.add_question_button)
        addQuestionEditor = view.findViewById(R.id.add_question_editor)
        currentQuestionTextView = view.findViewById(R.id.current_question)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFirebase()

        addQuestionButton.setOnClickListener {
            val value = addQuestionEditor.text.toString().toInt()
            val question = Question(value, "Why?", "Heh", ArrayList(mutableListOf("ha", "Heh")))
            REF_DATABASE_ROOT.child(NODE_QUESTIONS).child(value.toString()).setValue(question)
                .addOnCompleteListener {
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                }
        }

        val getData = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder()
                for (i in snapshot.children){
                    val id = i.child("1").child(CHILD_ID).value
                    val answer = i.child("1").child(CHILD_ANSWER).value
                    val text = i.child("2").child(CHILD_TEXT).value
                    sb.append("$id $text $answer")
                }
                currentQuestionTextView.text = sb
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        REF_DATABASE_ROOT.addValueEventListener(getData)
        REF_DATABASE_ROOT.addListenerForSingleValueEvent(getData)
    }
}