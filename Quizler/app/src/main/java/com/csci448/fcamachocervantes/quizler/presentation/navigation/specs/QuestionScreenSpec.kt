package com.csci448.fcamachocervantes.quizler.presentation.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.csci448.fcamachocervantes.quizler.presentation.question.QuestionScreen
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModel

object QuestionScreenSpec : IScreenSpec {
    override val route = "question"

    @Composable
    override fun Content(quizlerViewModel: QuizlerViewModel,
                         navController: NavController
    ) {
        QuestionScreen(
            questionViewModel = quizlerViewModel,
            onCheatClick = {navController.navigate("cheat")
            }
        )
    }


}