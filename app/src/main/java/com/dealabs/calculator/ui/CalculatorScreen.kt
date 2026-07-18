package com.dealabs.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dealabs.calculator.model.CalculatorState

@Composable
fun CalculatorScreen(
    state: CalculatorState,
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
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Display
        DisplaySection(state = state)
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Buttons
        ButtonsGrid(
            onNumberClick = onNumberClick,
            onOperatorClick = onOperatorClick,
            onEqualsClick = onEqualsClick,
            onClearClick = onClearClick,
            onDeleteClick = onDeleteClick,
            onDecimalClick = onDecimalClick,
            onPercentageClick = onPercentageClick,
            onNegateClick = onNegateClick
        )
    }
}