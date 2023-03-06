package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A1.R

@Composable
fun CalculateButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onClick,
        ) {
            Text( stringResource(id = R.string.calculate_value_label))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCalculateButton() {
    CalculateButton {}
}