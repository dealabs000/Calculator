package com.dealabs.calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsGrid(
    onNumberClick: (String) -> Unit,
    onOperatorClick: (String) -> Unit,
    onEqualsClick: () -> Unit,
    onClearClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onDecimalClick: () -> Unit,
    onPercentageClick: () -> Unit,
    onNegateClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Row 1: Clear, Delete, Percentage, Divide
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                label = "AC",
                type = ButtonType.FUNCTION,
                onClick = onClearClick,
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "⌫",
                type = ButtonType.FUNCTION,
                onClick = onDeleteClick,
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "%",
                type = ButtonType.FUNCTION,
                onClick = onPercentageClick,
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "÷",
                type = ButtonType.OPERATOR,
                onClick = { onOperatorClick("/") },
                modifier = Modifier.weight(1f)
            )
        }

        // Row 2: 7, 8, 9, Multiply
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                label = "7",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("7") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "8",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("8") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "9",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("9") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "×",
                type = ButtonType.OPERATOR,
                onClick = { onOperatorClick("*") },
                modifier = Modifier.weight(1f)
            )
        }

        // Row 3: 4, 5, 6, Subtract
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                label = "4",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("4") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "5",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("5") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "6",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("6") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "−",
                type = ButtonType.OPERATOR,
                onClick = { onOperatorClick("-") },
                modifier = Modifier.weight(1f)
            )
        }

        // Row 4: 1, 2, 3, Add
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                label = "1",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("1") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "2",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("2") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "3",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("3") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "+",
                type = ButtonType.OPERATOR,
                onClick = { onOperatorClick("+") },
                modifier = Modifier.weight(1f)
            )
        }

        // Row 5: Negate, 0, Decimal, Equals
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalculatorButton(
                label = "±",
                type = ButtonType.FUNCTION,
                onClick = onNegateClick,
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "0",
                type = ButtonType.NUMBER,
                onClick = { onNumberClick("0") },
                modifier = Modifier.weight(2f)
            )
            CalculatorButton(
                label = ".",
                type = ButtonType.NUMBER,
                onClick = onDecimalClick,
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                label = "=",
                type = ButtonType.EQUALS,
                onClick = onEqualsClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}