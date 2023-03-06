package com.csci448.fcamachocervantes.quizler.data

import com.csci448.fcamachocervantes.quizler.R

object QuestionRepo {
    public var questions = listOf(
        Question(R.string.question1, 2),
        Question(R.string.question2, 1),
        Question(R.string.question3, 1),
        Question(R.string.question4, 2),
        Question(R.string.question5, 2),
        Question(R.string.question6, 3, R.string.q6_choice1, R.string.q6_choice2, R.string.q6_choice3, R.string.q6_choice4)
    )
}