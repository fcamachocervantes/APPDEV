package com.csci448.fcamachocervantes.quizler.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.csci448.fcamachocervantes.quizler.data.Question

class QuizlerViewModel(private val mQuestions: List<Question>,
                       private var mCurrentQuestionIndex: Int = 0,
                       initialScore: Int = 0) : ViewModel() {

    private val mCurrentScoreState = mutableStateOf(initialScore)
    private var mCurrentQuestionState = mutableStateOf( mQuestions[mCurrentQuestionIndex] )
    private var mQuestionStatusList: MutableList<QuestionStatus> = MutableList(mQuestions.size+1) {QuestionStatus.UNANSWERED}
    private var mCurrentQuestionStatus = mutableStateOf( mQuestionStatusList[mCurrentQuestionIndex] )

    val currentScoreState: State<Int>
        get() = mCurrentScoreState

    val currentQuestion: State<Question>
        get() = mCurrentQuestionState

    val currentQuestionIndex: Int
        get() = mCurrentQuestionIndex

    val currentQuestionStatus: State<QuestionStatus>
        get() = mCurrentQuestionStatus

    fun moveToNextQuestion(){
        if(mCurrentQuestionIndex < mQuestions.size - 1) {
            mCurrentQuestionIndex += 1
        } else {
            mCurrentQuestionIndex = 0
        }
        mCurrentQuestionState.value = mQuestions[mCurrentQuestionIndex]
        mCurrentQuestionStatus.value = mQuestionStatusList[mCurrentQuestionIndex]
    }

    fun moveToPreviousQuestion(){
        if(mCurrentQuestionIndex > 0) {
            mCurrentQuestionIndex -= 1
        } else {
            mCurrentQuestionIndex = mQuestions.size - 1
        }
        mCurrentQuestionState.value = mQuestions[mCurrentQuestionIndex]
        mCurrentQuestionStatus.value = mQuestionStatusList[mCurrentQuestionIndex]
    }

    fun answeredCorrect(){
        mCurrentScoreState.value += 1
        mCurrentQuestionStatus.value = QuestionStatus.ANSWERED_CORRECT
        mQuestionStatusList[mCurrentQuestionIndex] = QuestionStatus.ANSWERED_CORRECT
    }

    fun answeredIncorrect(){
        mCurrentQuestionStatus.value = QuestionStatus.ANSWERED_INCORRECT
        mQuestionStatusList[mCurrentQuestionIndex] = QuestionStatus.ANSWERED_INCORRECT
    }

    fun cheated(){
        mCurrentQuestionStatus.value = QuestionStatus.CHEATED
        mQuestionStatusList[mCurrentQuestionIndex] = QuestionStatus.CHEATED
    }

    fun answeredCheated(){
        mCurrentQuestionStatus.value = QuestionStatus.ANSWERED_CHEATED
        mQuestionStatusList[mCurrentQuestionIndex] = QuestionStatus.ANSWERED_CHEATED
    }
}