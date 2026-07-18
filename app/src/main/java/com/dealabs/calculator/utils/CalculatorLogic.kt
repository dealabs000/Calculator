package com.dealabs.calculator.utils

object CalculatorLogic {
    fun evaluate(first: Double, second: Double, operator: String): Double {
        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            "/" -> {
                if (second == 0.0) {
                    Double.NaN
                } else {
                    first / second
                }
            }
            else -> second
        }
    }
}