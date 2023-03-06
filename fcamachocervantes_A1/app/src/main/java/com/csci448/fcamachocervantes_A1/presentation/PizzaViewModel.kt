package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import com.csci448.fcamachocervantes_A1.R
import com.csci448.fcamachocervantes_A1.data.Pizza
import com.csci448.fcamachocervantes_A1.data.PizzaRepo
import java.lang.Math.ceil

class PizzaViewModel {
    var pizzaList = PizzaRepo.pizzas
    var hungerList = PizzaRepo.hungerLevels

    private val numPeopleState: MutableState<Int?> = mutableStateOf(0)

    val totalCostState: MutableState<Double> = mutableStateOf(0.00)
    val numPizzaState: MutableState<Int> = mutableStateOf(0)
    val numPeopleStringState: MutableState<String?> =  mutableStateOf("0")
    val selectedHungerState: MutableState<String> = mutableStateOf("")
    val selectedPizzaState: MutableState<Pizza> = mutableStateOf(pizzaList[0])
    val expandedMenu: MutableState<Boolean> = mutableStateOf(false)

    fun setNewNumPeopleString(newNumPeople: String) {
        numPeopleStringState.value = newNumPeople
        val numPeopleInt = numPeopleStringState.value?.toIntOrNull()
        numPeopleState.value = numPeopleInt
    }

    fun calculatePizzaValues() {
        var numSlices = 0

        if(selectedHungerState.value == "Light")
        {
            numSlices = 1 * numPeopleState.value!!
        }
        if(selectedHungerState.value == "Medium")
        {
            numSlices = 2 * numPeopleState.value!!
        }
        if(selectedHungerState.value == "Ravenous")
        {
            numSlices = 4 * numPeopleState.value!!
        }

        if(numSlices % 8 == 0)
        {
            numPizzaState.value = numSlices / 8
        }
        else
        {
            numPizzaState.value = (ceil(numSlices / 8.0)).toInt()
        }

        totalCostState.value = numPizzaState.value * selectedPizzaState.value.price

    }
}