package com.dealabs.calculator.model

data class CalculatorState(
    val display: String = "0",
    val expression: String = "",
    val firstNumber: String = "",
    val secondNumber: String = "",
    val currentOperator: String? = null,
    val isNewNumber: Boolean = true,
    val isResultDisplayed: Boolean = false
)