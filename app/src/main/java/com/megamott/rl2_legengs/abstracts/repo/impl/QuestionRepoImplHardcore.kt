package com.megamott.rl2_legengs.abstracts.repo.impl

import com.megamott.rl2_legengs.abstracts.entity.Question
import com.megamott.rl2_legengs.abstracts.repo.QuestionsRepo
import java.util.*
import kotlin.NoSuchElementException

class QuestionRepoImplHardcore : QuestionsRepo {

    private val questionsQueue : Queue<Question> = LinkedList()

    init {
        questionsQueue.add(Question(1, "A", "AA", arrayListOf("AAA")))
        questionsQueue.add(Question(2, "B", "BB", arrayListOf("BBB")))
    }

    override fun getQuestion() : Question? {
        return if (!questionsQueue.isEmpty()) questionsQueue.poll() else throw NoSuchElementException("Queue is empty!")
    }
}