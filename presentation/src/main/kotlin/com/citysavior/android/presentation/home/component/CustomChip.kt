package com.citysavior.android.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import com.citysavior.android.presentation.common.constant.Colors
import com.citysavior.android.presentation.common.constant.Sizes
import com.citysavior.android.presentation.common.constant.TextStyles

@Composable
fun CustomChip(
    text: String,
    textStyle: TextStyle,
    size: DpSize,
    backgroundColor : Color = Colors.PRIMARY_BLUE,
) {
    Box(
        modifier = Modifier
            .size(size)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = Sizes.WIDGET_ROUND)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
        )
    }
}