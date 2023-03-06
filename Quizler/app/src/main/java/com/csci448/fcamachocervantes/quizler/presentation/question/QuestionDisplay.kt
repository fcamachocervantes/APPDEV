package com.csci448.fcamachocervantes.quizler.presentation.question

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes.quizler.R
import com.csci448.fcamachocervantes.quizler.data.Question
import com.csci448.fcamachocervantes.quizler.data.QuestionRepo
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuestionStatus

private const val LOG_TAG = "448.QuestionDisplay"


@Composable
fun QuestionDisplay(
    question: Question,
    onCorrectAnswer: () -> Unit,
    onWrongAnswer: () -> Unit,
    onCheatAnswer: () -> Unit,
    questionStatus: QuestionStatus,
    orientation: Int = Configuration.ORIENTATION_PORTRAIT
) {
    Log.d(LOG_TAG, stringResource(id = question.questionTextId))

    when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
            ){
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.75F)
                ){
                    QuestionTextCard(question = question)
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    QuestionChoiceButton(
                        question = question,
                        questionId = question.choice1Id,
                        questionChoiceNum = 1,
                        questionStatus = questionStatus,
                        onCorrectAnswer,
                        onWrongAnswer,
                        onCheatAnswer
                    )
                    QuestionChoiceButton(
                        question = question,
                        questionId = question.choice2Id,
                        questionChoiceNum = 2,
                        questionStatus = questionStatus,
                        onCorrectAnswer,
                        onWrongAnswer,
                        onCheatAnswer
                    )
                    if(question.choice3Id != null)
                    {
                        QuestionChoiceButton(
                            question = question,
                            questionId = question.choice3Id,
                            questionChoiceNum = 3,
                            questionStatus = questionStatus,
                            onCorrectAnswer,
                            onWrongAnswer,
                            onCheatAnswer
                        )
                    }
                    if(question.choice4Id != null)
                    {
                        QuestionChoiceButton(
                            question = question,
                            questionId = question.choice4Id,
                            questionChoiceNum = 4,
                            questionStatus = questionStatus,
                            onCorrectAnswer,
                            onWrongAnswer,
                            onCheatAnswer
                        )
                    }
                }
            }
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.65F)
                ){
                    QuestionTextCard(question = question)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuestionChoiceButton(
                        question = question,
                        questionId = question.choice1Id,
                        questionChoiceNum = 1,
                        questionStatus = questionStatus,
                        onCorrectAnswer,
                        onWrongAnswer,
                        onCheatAnswer
                    )
                    QuestionChoiceButton(
                        question = question,
                        questionId = question.choice2Id,
                        questionChoiceNum = 2,
                        questionStatus = questionStatus,
                        onCorrectAnswer,
                        onWrongAnswer,
                        onCheatAnswer
                    )
                }
                if (question.choice3Id != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        QuestionChoiceButton(
                            question = question,
                            questionId = question.choice3Id,
                            questionChoiceNum = 3,
                            questionStatus = questionStatus,
                            onCorrectAnswer,
                            onWrongAnswer,
                            onCheatAnswer
                        )
                        if (question.choice4Id != null) {
                            QuestionChoiceButton(
                                question = question,
                                questionId = question.choice4Id,
                                questionChoiceNum = 4,
                                questionStatus = questionStatus,
                                onCorrectAnswer,
                                onWrongAnswer,
                                onCheatAnswer
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewQuestionDisplay() {
    QuestionDisplay(
        question = Question(R.string.question1, 2),
        {},
        {},
        {},
        QuestionStatus.ANSWERED_CORRECT
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewMultiQuestionDisplay() {
    val question = QuestionRepo.questions[5]
    QuestionDisplay(question = question, {}, {}, {}, QuestionStatus.UNANSWERED)
}

@Preview(showBackground = true, device = "spec:parent=pixel_5,orientation=landscape")
@Composable
private fun PreviewLandScape(){
    val question = QuestionRepo.questions[5]
    QuestionDisplay(question = question, {}, {}, {}, QuestionStatus.UNANSWERED, Configuration.ORIENTATION_LANDSCAPE)
}