package com.csci448.fcamachocervantes.quizler.presentation.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModel

sealed interface IScreenSpec{
    companion object {
        val allScreens = IScreenSpec::class.sealedSubclasses.map { it.objectInstance }
        val root = "quizler"
        val startDestination = QuestionScreenSpec.route
    }

    val route: String

    @Composable
    fun Content(quizlerViewModel: QuizlerViewModel,
                navController: NavController
    )
}