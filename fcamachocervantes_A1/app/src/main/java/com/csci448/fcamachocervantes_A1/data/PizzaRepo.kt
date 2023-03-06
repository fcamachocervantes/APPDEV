package com.csci448.fcamachocervantes_A1.data

import com.csci448.fcamachocervantes_A1.R

object PizzaRepo {
    public var pizzas = listOf(
        Pizza(
            name = "Cheese Pizza",
            price = 8.50
        ),
        Pizza(
            name = "Detroit Pizza",
            price = 14.50
        ),
        Pizza(
            name = "Hawaiian Pizza",
            price = 11.50
        ),
        Pizza(
            name = "Pepperoni Pizza",
            price = 10.25
        ),
        Pizza(
            name = "Pizza Margherita",
            price = 9.75
        ),
        Pizza(
            name = "Sausage Pizza",
            price = 10.25
        ),
        Pizza(
            name = "Sicilian Pizza",
            price = 15.00
        ),
    )
    public var hungerLevels = listOf(
        "Light",
        "Medium",
        "Ravenous",
    )
}