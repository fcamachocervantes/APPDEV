package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A1.R
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import com.csci448.fcamachocervantes_A1.data.Pizza
import com.csci448.fcamachocervantes_A1.data.PizzaRepo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaChoiceDropDown(pizzaList: List<Pizza>,
                        selectedItem: Pizza,
                        expanded: Boolean,
                        onExpandedMenu: (Boolean) -> Unit,
                        onPizzaSelected: (Pizza) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.chosen_pizza_label)
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { onExpandedMenu(!expanded) }
        ) {
            TextField(
                TextFieldValue(text = selectedItem.name + " $(" + String.format("%.2f", selectedItem.price) + " ea)"),
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { onExpandedMenu(false) }
            ) {
                pizzaList.forEach { selectedOption ->
                    DropdownMenuItem(
                        text = { Text(selectedOption.name + " $(" + String.format("%.2f", selectedOption.price) + " ea)") },
                        onClick = {
                            onPizzaSelected(selectedOption)
                            onExpandedMenu(false)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPizzaChoiceDropDown() {
    PizzaChoiceDropDown(PizzaRepo.pizzas, PizzaRepo.pizzas[0], false, onExpandedMenu = {}, onPizzaSelected = {})
}

