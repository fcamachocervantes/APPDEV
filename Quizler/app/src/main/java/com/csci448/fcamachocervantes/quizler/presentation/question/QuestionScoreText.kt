package com.csci448.fcamachocervantes.quizler.presentation.question

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes.quizler.R

private const val LOG_TAG = "448.QuestionScoreText"

@Composable
fun QuestionScoreText(currentScore: Int) {

    Log.d(LOG_TAG, stringResource(id = R.string.label_score_formatter, currentScore))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.1F),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.label_score_formatter, currentScore),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
private fun PreviewQuestionScoreText() {
    QuestionScoreText(currentScore = 0)
}