package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculateScreen(pizzaViewModel: PizzaViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        EnterPeopleBox(
            peopleText = pizzaViewModel.numPeopleStringState.value,
            onNewPeopleValue = { newNumPeopleString -> pizzaViewModel.setNewNumPeopleString(newNumPeopleString) }
        )

        HungerRadioButton(
            hungerList = pizzaViewModel.hungerList,
            selectedHungerState = pizzaViewModel.selectedHungerState.value,
            onHungerStateSelected = {newModelState -> pizzaViewModel.selectedHungerState.value = newModelState}
        )

        PizzaChoiceDropDown(
            pizzaList = pizzaViewModel.pizzaList,
            selectedItem = pizzaViewModel.selectedPizzaState.value,
            expanded = pizzaViewModel.expandedMenu.value,
            onExpandedMenu = {newExpandedState -> pizzaViewModel.expandedMenu.value = newExpandedState},
            onPizzaSelected = {newModelState -> pizzaViewModel.selectedPizzaState.value = newModelState}
        )

        CalculateButton(
            onClick = { pizzaViewModel.calculatePizzaValues() }
        )

        PizzaTextNeededCost(
            pizzaNeeded = pizzaViewModel.numPizzaState.value,
            totalCost = pizzaViewModel.totalCostState.value
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCalculateScreen() {
    CalculateScreen(PizzaViewModel())
}