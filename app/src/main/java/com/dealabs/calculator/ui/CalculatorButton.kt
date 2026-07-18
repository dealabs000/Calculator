package com.dealabs.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class ButtonType {
    NUMBER,
    OPERATOR,
    FUNCTION,
    EQUALS
}

@Composable
fun CalculatorButton(
    label: String,
    type: ButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (type) {
        ButtonType.NUMBER -> Color(0xFF333333)
        ButtonType.OPERATOR -> Color(0xFFFF9F0A)
        ButtonType.FUNCTION -> Color(0xFFA5A5A5)
        ButtonType.EQUALS -> Color(0xFFFF9F0A)
    }
    
    val textColor = when (type) {
        ButtonType.NUMBER -> Color.White
        ButtonType.OPERATOR -> Color.White
        ButtonType.FUNCTION -> Color.Black
        ButtonType.EQUALS -> Color.White
    }

    Box(
        modifier = modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium
        )
    }
}