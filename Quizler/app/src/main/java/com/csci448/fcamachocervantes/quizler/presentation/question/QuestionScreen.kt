package com.csci448.fcamachocervantes.quizler.presentation.question

import android.content.res.Configuration
import android.media.midi.MidiOutputPort
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes.quizler.R
import com.csci448.fcamachocervantes.quizler.data.QuestionRepo
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModel

private const val LOG_TAG = "448.QuestionScreen"

@Composable
fun QuestionScreen(questionViewModel: QuizlerViewModel, onCheatClick: () -> Unit) {
    val currentContext = LocalContext.current
    val orientation = LocalConfiguration.current.orientation

    Log.d(LOG_TAG, "Composing Question Screen")

    when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE ->{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(bottom = 20.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.80F)
                ){
                    Row(

                    ){
                        Button(
                            onClick = onCheatClick
                        ){
                            Text("Cheat!")
                        }
                        QuestionScoreText(
                            currentScore = questionViewModel.currentScoreState.value
                        )
                    }
                    QuestionDisplay(
                        question = questionViewModel.currentQuestion.value,
                        onCorrectAnswer = {
                            questionViewModel.answeredCorrect()
                            Toast.makeText(
                                currentContext,
                                R.string.message_correct,
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        },
                        onWrongAnswer = {
                            questionViewModel.answeredIncorrect()
                            Toast.makeText(
                                currentContext,
                                R.string.message_wrong,
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        },
                        onCheatAnswer = {
                            questionViewModel.answeredCheated()
                            Toast.makeText(
                                currentContext,
                                R.string.message_cheat,
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        },
                        questionStatus = questionViewModel.currentQuestionStatus.value,
                        orientation = orientation
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 35.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    QuestionButton(
                        buttonText = stringResource(id = R.string.label_previous),
                        onButtonClick = { questionViewModel.moveToPreviousQuestion() }
                    )
                    QuestionButton(
                        buttonText = stringResource(id = R.string.label_next),
                        onButtonClick = { questionViewModel.moveToNextQuestion() }
                    )
                }
            }
        }
        else -> {
            Column(

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        modifier = Modifier
                            .padding(start = 50.dp),
                        onClick = onCheatClick
                    ){
                        Text("Cheat!")
                    }
                    QuestionScoreText(
                        currentScore = questionViewModel.currentScoreState.value
                    )
                }
                QuestionDisplay(
                    question = questionViewModel.currentQuestion.value,
                    onCorrectAnswer = {
                        questionViewModel.answeredCorrect()
                        Toast.makeText(
                            currentContext,
                            R.string.message_correct,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    onWrongAnswer = {
                        questionViewModel.answeredIncorrect()
                        Toast.makeText(
                            currentContext,
                            R.string.message_wrong,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    onCheatAnswer = {
                        questionViewModel.answeredCheated()
                        Toast.makeText(
                            currentContext,
                            R.string.message_cheat,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    questionStatus = questionViewModel.currentQuestionStatus.value,
                    orientation = orientation
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuestionButton(
                        buttonText = stringResource(id = R.string.label_previous),
                        onButtonClick = { questionViewModel.moveToPreviousQuestion() }
                    )
                    QuestionButton(
                        buttonText = stringResource(id = R.string.label_next),
                        onButtonClick = { questionViewModel.moveToNextQuestion() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewQuestionScreen() {
    QuestionScreen(QuizlerViewModel(QuestionRepo.questions), {})
}

@Preview(showBackground = true, device = "spec:parent=pixel_5,orientation=landscape")
@Composable
private fun PreviewQuestionScreenLandScape() {
    QuestionScreen(QuizlerViewModel(QuestionRepo.questions), {})
}