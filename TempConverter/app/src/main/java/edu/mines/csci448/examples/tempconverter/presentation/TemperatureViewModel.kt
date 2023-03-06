package edu.mines.csci448.examples.tempconverter.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class TemperatureViewModel {

    val celsiusState: MutableState<Double> = mutableStateOf(0.0)
    val celsiusStringState = mutableStateOf("")
    val fahrenheitState = mutableStateOf(32.0)

    fun setNewCelsiusString(newCelsius: String) {
        celsiusStringState.value = newCelsius
    }

    fun convertToFahrenheit(): Boolean {
        val celsiusDouble = celsiusStringState.value.toDoubleOrNull()
        return if(celsiusDouble != null) {
            celsiusState.value = celsiusDouble
            fahrenheitState.value = (celsiusDouble * 9.0 / 5.0) + 32.0
            true
        } else {
            false
        }
    }
}