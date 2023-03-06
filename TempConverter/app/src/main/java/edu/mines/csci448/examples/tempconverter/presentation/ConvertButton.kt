package edu.mines.csci448.examples.tempconverter.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.mines.csci448.examples.tempconverter.R

@Composable
fun ConvertButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    ) {
        Text( stringResource(id = R.string.convert_temp_label) )
    }
}

@Preview
@Composable
private fun PreviewConvertButton() {
    ConvertButton {}
}