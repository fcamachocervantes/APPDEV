package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A1.R

@Composable
fun EnterPeopleBox(peopleText: String?,
                    onNewPeopleValue: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp),
            text = stringResource(id = R.string.number_of_people_label)
        )
        if (peopleText != null) {
            TextField(
                value = peopleText,
                onValueChange = onNewPeopleValue,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EnterPeopleBox() {
    EnterPeopleBox(peopleText = "", onNewPeopleValue = {})
}