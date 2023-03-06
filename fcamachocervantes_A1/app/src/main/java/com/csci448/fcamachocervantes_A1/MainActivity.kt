package com.csci448.fcamachocervantes_A1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.csci448.fcamachocervantes_A1.presentation.CalculateScreen
import com.csci448.fcamachocervantes_A1.presentation.PizzaViewModel
import com.csci448.fcamachocervantes_A1.ui.theme.Fcamachocervantes_A1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fcamachocervantes_A1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val pizzaViewModel = PizzaViewModel()
                    CalculateScreen(pizzaViewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Fcamachocervantes_A1Theme {
        val pizzaViewModel = PizzaViewModel()
        CalculateScreen(pizzaViewModel = pizzaViewModel)
    }
}