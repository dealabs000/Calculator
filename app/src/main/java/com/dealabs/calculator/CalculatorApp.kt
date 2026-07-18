package com.dealabs.calculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dealabs.calculator.ui.CalculatorScreen
import com.dealabs.calculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorApp(
    viewModel: CalculatorViewModel = viewModel()
) {
    val state by viewModel.state
    CalculatorScreen(
        state = state,
        onNumberClick = viewModel::onNumberClick,
        onOperatorClick = viewModel::onOperatorClick,
        onEqualsClick = viewModel::onEqualsClick,
        onClearClick = viewModel::onClearClick,
        onDeleteClick = viewModel::onDeleteClick,
        onDecimalClick = viewModel::onDecimalClick,
        onPercentageClick = viewModel::onPercentageClick,
        onNegateClick = viewModel::onNegateClick
    )
}