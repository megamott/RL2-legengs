package com.megamott.rl2_legengs.abstracts.repo.impl

import com.megamott.rl2_legengs.abstracts.entity.local_data.Question
import com.megamott.rl2_legengs.abstracts.entity.local_data.QuestionDAO
import com.megamott.rl2_legengs.abstracts.repo.QuestionRepo

class QuestionRepoImplRoom(private val questionDAO: QuestionDAO) : QuestionRepo {

    override fun getQuestions(): List<Question> = questionDAO.readAllQuestions()

    override fun addQuestion() = questionDAO.addQuestions(Question("Who am i?", "Matvey", "Matvey 1 2 3"))

}