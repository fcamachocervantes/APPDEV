package com.csci448.fcamachocervantes_A1.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A1.data.Pizza

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaItem(pizza: Pizza,
                onPizzaSelected: (Pizza) -> Unit) {
    TextButton(
        onClick = { onPizzaSelected(pizza) },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "${pizza.name} ($${pizza.price} ea)",
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPizzaItem() {
    val pizza = Pizza("Cheese", 8.50)
    PizzaItem(pizza = pizza, onPizzaSelected = {})
}