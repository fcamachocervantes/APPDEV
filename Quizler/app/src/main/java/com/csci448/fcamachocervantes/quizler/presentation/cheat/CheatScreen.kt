package com.csci448.fcamachocervantes.quizler.presentation.cheat

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuestionStatus
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModel

@Composable
fun CheatScreen(quizlerViewModel: QuizlerViewModel) {
    Column(

    ){
        Text("Are you sure you want to cheat?")
        Button(
            onClick = {quizlerViewModel.cheated()}
        ){
            Text("Cheat")
        }
        if(quizlerViewModel.currentQuestionStatus.value == QuestionStatus.CHEATED){
            val correctAnswerVal = quizlerViewModel.currentQuestion.value.correctChoiceNumber

            if(correctAnswerVal == 1) {
                Text(stringResource(id = quizlerViewModel.currentQuestion.value.choice1Id))
            }
            else if(correctAnswerVal == 2) {
                Text(stringResource(id = quizlerViewModel.currentQuestion.value.choice2Id))
            }
            else if(correctAnswerVal == 3) {
                Text(stringResource(id = quizlerViewModel.currentQuestion.value.choice3Id!!))
            }
            else if(correctAnswerVal == 4) {
                Text(stringResource(id = quizlerViewModel.currentQuestion.value.choice4Id!!))
            }
        }
    }
}