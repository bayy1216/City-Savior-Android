package com.citysavior.android.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.citysavior.android.presentation.common.constant.Colors
import com.citysavior.android.presentation.common.constant.Sizes
import com.citysavior.android.presentation.common.constant.TextStyles

@Composable
fun ProfileBox(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = Colors.PRIMARY_BLUE,
                    shape = RoundedCornerShape(size = 60.dp)
                ),
        )
        Spacer(modifier = Modifier.width(Sizes.INTERVAL_MEDIUM2))
        Column {
            Text(
                text = title,
                style = TextStyles.TITLE_LARGE2,
            )
            Text(
                text =content,
                style = TextStyles.CONTENT_TEXT2_STYLE.copy(
                    color = Colors.GREY_TEXT
                ),
            )
        }
    }
}