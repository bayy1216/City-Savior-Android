package com.citysavior.android.presentation.home.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.citysavior.android.presentation.common.constant.Sizes

@Composable
fun CustomProgress(
    width: Dp,
    height: Dp,
    progress: Float,
    color: Color,
){
    Canvas(
        modifier = Modifier
            .progressSemantics(progress)
            .size(width, height)
    ) {
        val strokeWidth = size.height
        drawLinearIndicatorTrack(Color.White, strokeWidth)
        drawLinearIndicator(0f, progress, color, strokeWidth)
    }
}

fun DrawScope.drawLinearIndicatorTrack(
    color: Color,
    strokeWidth: Float
) = drawLinearIndicator(0f, 1f, color, strokeWidth)
fun DrawScope.drawLinearIndicator(
    startFraction: Float,
    endFraction: Float,
    color: Color,
    strokeWidth: Float
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke
    val yOffset = height / 2

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) startFraction else 1f - endFraction) * width
    val barEnd = (if (isLtr) endFraction else 1f - startFraction) * width

    // Progress line
    drawRoundRect(
        color = color,
        size = Size(barEnd - barStart, strokeWidth),
        topLeft = Offset(barStart, yOffset - strokeWidth / 2),
        cornerRadius = CornerRadius(strokeWidth / 2, strokeWidth / 2),
    )
    //drawLine(color, Offset(barStart, yOffset), Offset(barEnd, yOffset), strokeWidth)
}

@Preview
@Composable
fun PreviewCustomProgress(){
    CustomProgress(
        width = 74.dp,
        height = 5.dp,
        progress = 0.4f,
        color = Color.Red,
    )
}