package com.csci448.fcamachocervantes.quizler.presentation.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.csci448.fcamachocervantes.quizler.presentation.cheat.CheatScreen
import com.csci448.fcamachocervantes.quizler.presentation.question.QuestionScreen
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModel

object CheatScreenSpec : IScreenSpec {
    override val route = "cheat"

    @Composable
    override fun Content(quizlerViewModel: QuizlerViewModel,
                         navController: NavController
    ){
        CheatScreen(quizlerViewModel = quizlerViewModel)
    }
}