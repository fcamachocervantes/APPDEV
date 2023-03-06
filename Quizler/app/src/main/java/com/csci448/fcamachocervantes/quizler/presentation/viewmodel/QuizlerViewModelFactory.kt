package com.csci448.fcamachocervantes.quizler.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.fcamachocervantes.quizler.data.QuestionRepo

private const val LOG_TAG = "448.ViewModelFactory"

class QuizlerViewModelFactory(private val initialIndex: Int = 0,
                              private val initialScore: Int = 0) : ViewModelProvider.NewInstanceFactory() {
    fun getViewModelClass() = QuizlerViewModel::class.java

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d(LOG_TAG, "Creating $modelClass")

        if (modelClass.isAssignableFrom(getViewModelClass()))
            return modelClass
                .getConstructor(List::class.java, Int::class.java, Int::class.java)
                .newInstance(QuestionRepo.questions, initialIndex, initialScore)
        throw IllegalArgumentException("Unknown ViewModel")
    }
}