package com.csci448.fcamachocervantes.quizler.presentation.question

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes.quizler.data.Question

@Composable
fun QuestionTextCard(question: Question){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .border(
                width = 5.dp,
                color = MaterialTheme.colorScheme.background,
                RoundedCornerShape(10.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(1F)
                .fillMaxWidth()
                .padding(all = 5.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            Text(
                text = stringResource(id = question.questionTextId),
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                lineHeight = 50.sp,
            )
        }
    }
}