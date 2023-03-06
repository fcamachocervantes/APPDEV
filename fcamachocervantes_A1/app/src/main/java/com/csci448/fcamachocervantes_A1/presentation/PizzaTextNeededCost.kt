package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A1.R

@Composable
fun PizzaTextNeededCost(pizzaNeeded: Int, totalCost: Double) {
    Column(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = stringResource(id = R.string.total_pizzas_label))
            Text(text = "$pizzaNeeded")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = stringResource(id = R.string.total_cost_label))
            Text(text = "$(" + String.format("%.2f", totalCost)  + " ea)")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPizzaText(){
    PizzaTextNeededCost(pizzaNeeded = 0, totalCost = 0.00)
}