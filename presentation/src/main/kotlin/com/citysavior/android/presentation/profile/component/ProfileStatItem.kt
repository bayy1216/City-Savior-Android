package com.citysavior.android.presentation.profile.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.citysavior.android.presentation.common.constant.Colors
import com.citysavior.android.presentation.common.constant.Sizes
import com.citysavior.android.presentation.common.constant.TextStyles

@Composable
fun ProfileStatItem (
    modifier: Modifier = Modifier,
    label: String,
    content: String,
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Filled.ThumbUp,
            contentDescription = null,
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.height(Sizes.INTERVAL1))
        Text(
            text = label,
            style = TextStyles.CONTENT_TEXT1_STYLE,
        )
        Spacer(modifier = Modifier.height(Sizes.INTERVAL1))
        Text(
            text = content,
            style = TextStyles.CONTENT_TEXT3_STYLE.copy(
                color = Colors.GREY_TEXT,
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ProfileStatItemPreview() {
    ProfileStatItem(
        label = "100",
        content = "Total Damage",
    )
}