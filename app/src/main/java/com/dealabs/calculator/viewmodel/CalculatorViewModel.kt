package com.dealabs.calculator.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dealabs.calculator.model.CalculatorState
import com.dealabs.calculator.utils.CalculatorLogic

class CalculatorViewModel : ViewModel() {
    private val _state = mutableStateOf(CalculatorState())
    val state: State<CalculatorState> = _state

    fun onNumberClick(number: String) {
        val currentState = _state.value
        
        if (currentState.isResultDisplayed) {
            _state.value = currentState.copy(
                display = number,
                expression = "",
                firstNumber = number,
                secondNumber = "",
                currentOperator = null,
                isNewNumber = true,
                isResultDisplayed = false
            )
            return
        }

        val newDisplay = if (currentState.isNewNumber) {
            if (number == ".") "0." else number
        } else {
            if (number == "." && currentState.display.contains(".")) {
                return
            }
            currentState.display + number
        }

        val newFirstNumber = if (currentState.currentOperator == null) {
            newDisplay
        } else {
            currentState.firstNumber
        }

        _state.value = currentState.copy(
            display = newDisplay,
            firstNumber = newFirstNumber,
            isNewNumber = false,
            isResultDisplayed = false
        )
    }

    fun onOperatorClick(operator: String) {
        val currentState = _state.value
        
        if (currentState.currentOperator != null && !currentState.isNewNumber) {
            calculateResult()
        }

        _state.value = currentState.copy(
            currentOperator = operator,
            firstNumber = currentState.display,
            secondNumber = "",
            isNewNumber = true,
            isResultDisplayed = false,
            expression = "${currentState.display} $operator "
        )
    }

    fun onEqualsClick() {
        calculateResult()
    }

    fun onClearClick() {
        _state.value = CalculatorState()
    }

    fun onDeleteClick() {
        val currentState = _state.value
        if (currentState.display.length > 1) {
            _state.value = currentState.copy(
                display = currentState.display.dropLast(1),
                isNewNumber = false
            )
        } else {
            _state.value = currentState.copy(
                display = "0",
                isNewNumber = true
            )
        }
    }

    fun onDecimalClick() {
        if (!_state.value.display.contains(".")) {
            onNumberClick(".")
        }
    }

    fun onPercentageClick() {
        val currentState = _state.value
        val number = currentState.display.toDoubleOrNull()
        if (number != null) {
            val result = number / 100
            _state.value = currentState.copy(
                display = formatNumber(result),
                isNewNumber = true
            )
        }
    }

    fun onNegateClick() {
        val currentState = _state.value
        if (currentState.display != "0") {
            val number = currentState.display.toDoubleOrNull()
            if (number != null) {
                val result = -number
                _state.value = currentState.copy(
                    display = formatNumber(result)
                )
            }
        }
    }

    private fun calculateResult() {
        val currentState = _state.value
        val first = currentState.firstNumber.toDoubleOrNull()
        val second = currentState.display.toDoubleOrNull()
        val operator = currentState.currentOperator

        if (first != null && second != null && operator != null) {
            val result = CalculatorLogic.evaluate(first, second, operator)
            val formattedResult = formatNumber(result)
            
            _state.value = currentState.copy(
                display = formattedResult,
                expression = "${currentState.firstNumber} $operator ${currentState.display} =",
                firstNumber = formattedResult,
                secondNumber = "",
                currentOperator = null,
                isNewNumber = true,
                isResultDisplayed = true
            )
        } else {
            _state.value = currentState.copy(
                isResultDisplayed = true
            )
        }
    }

    private fun formatNumber(number: Double): String {
        return if (number % 1 == 0.0) {
            number.toLong().toString()
        } else {
            number.toString().trimEnd('0').trimEnd('.')
        }
    }
}