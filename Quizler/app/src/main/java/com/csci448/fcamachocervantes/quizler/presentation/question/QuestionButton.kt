package com.csci448.fcamachocervantes.quizler.presentation.question

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val LOG_TAG = "448.QuestionButton"

@Composable
fun QuestionButton(
    buttonText: String,
    onButtonClick: () -> Unit,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {

    Log.d(LOG_TAG, buttonText)

    ElevatedButton(
        onClick = onButtonClick,
        modifier = Modifier
            .width(150.dp)
            .height(75.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        enabled = enabled,
        colors = colors,
        elevation = ButtonDefaults.buttonElevation(2.dp, 8.dp, 2.dp, 2.dp, 0.dp)
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewQuestionButton() {
    QuestionButton("Next", {})
}

@Preview(showBackground = true)
@Composable
private fun PreviewQuestionButtonEnabled() {
    QuestionButton("Next", {}, false)
}