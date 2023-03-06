package edu.mines.csci448.examples.tempconverter.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import edu.mines.csci448.examples.tempconverter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterTemperatureBox(tempText: String,
                        onNewTempValue: (String) -> Unit) {
    TextField(
        value = tempText,
        onValueChange = onNewTempValue,
        label = { Text(text = stringResource(id = R.string.enter_temp_label)) }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewEnterTemperatureBox() {
    EnterTemperatureBox(tempText = "", onNewTempValue = {})
}