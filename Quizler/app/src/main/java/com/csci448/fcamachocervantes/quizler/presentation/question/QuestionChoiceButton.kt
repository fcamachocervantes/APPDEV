package com.csci448.fcamachocervantes.quizler.presentation.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes.quizler.data.Question
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuestionStatus
import com.csci448.fcamachocervantes.quizler.ui.theme.Blue20
import com.csci448.fcamachocervantes.quizler.ui.theme.Gold60
import com.csci448.fcamachocervantes.quizler.ui.theme.Red40

private fun checkAnswerChoice(
    chosenChoice: Int,
    correctChoice: Int,
    questionStatus: QuestionStatus,
    onCorrectAnswer: () -> Unit,
    onWrongAnswer: () -> Unit,
    onCheatAnswer: () -> Unit
) {
    if(questionStatus == QuestionStatus.CHEATED) {
        onCheatAnswer()
    } else if (chosenChoice == correctChoice) {
        onCorrectAnswer()
    } else {
        onWrongAnswer()
    }
}

@Composable
fun QuestionChoiceButton(
    question: Question,
    questionId: Int,
    questionChoiceNum: Int,
    questionStatus: QuestionStatus,
    onCorrectAnswer: () -> Unit,
    onWrongAnswer: () -> Unit,
    onCheatAnswer: () -> Unit
) {

    val correctButtonColors =
        ButtonDefaults.buttonColors(disabledContainerColor = Gold60, disabledContentColor = Blue20)
    val incorrectButtonColors =
        ButtonDefaults.buttonColors(disabledContentColor = Red40, disabledContainerColor = Gold60)
    val defaultButtonColors = ButtonDefaults.buttonColors()

    fun checkButtonColor(
        chosenChoice: Int,
        question: Question,
        questionStatus: QuestionStatus,
    ): ButtonColors {

        return if (chosenChoice == question.correctChoiceNumber && questionStatus == QuestionStatus.ANSWERED_CORRECT) {
            correctButtonColors
        } else if (chosenChoice == question.correctChoiceNumber && questionStatus == QuestionStatus.ANSWERED_INCORRECT) {
            incorrectButtonColors
        } else {
            defaultButtonColors
        }
    }

    var buttonColors = defaultButtonColors


    buttonColors = checkButtonColor(questionChoiceNum, question, questionStatus)

    QuestionButton(
        buttonText = stringResource(id = questionId),
        onButtonClick = {
            checkAnswerChoice(
                questionChoiceNum, question.correctChoiceNumber, questionStatus, onCorrectAnswer, onWrongAnswer, onCheatAnswer
            )
        },
        enabled = questionStatus == QuestionStatus.UNANSWERED || questionStatus == QuestionStatus.CHEATED,
        colors = buttonColors
    )
}