package edu.mines.csci448.examples.tempconverter.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TemperatureText(celsius: Double, fahrenheit: Double) {
    Text(text = "$celsius C = $fahrenheit F")
}

@Preview(showBackground = true)
@Composable
private fun PreviewTemperatureText() {
    TemperatureText(celsius = 0.0, fahrenheit = 32.0)
}

@Preview(showBackground = true)
@Composable
private fun PreviewTemperatureText2() {
    TemperatureText(celsius = 100.0, fahrenheit = 212.0)
}