package com.citysavior.android.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysavior.android.presentation.common.constant.Colors
import com.citysavior.android.presentation.common.constant.Sizes
import com.citysavior.android.presentation.common.constant.TextStyles
import com.citysavior.android.presentation.common.utils.drawColoredShadow
import com.citysavior.android.presentation.home.component.CustomProgress

@Composable
fun AchievementItem(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    progress: Pair<Int, Int>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(Sizes.DAILY_PROGRESS_HEIGHT)
            .background(
                Color.White,
                shape = RoundedCornerShape(size = Sizes.WIDGET_ROUND)
            )
            .drawColoredShadow(
                color = Color.Gray,
                borderRadius = Sizes.WIDGET_ROUND,
                shadowRadius = 10.dp,
                offsetX = 0.dp,
                offsetY = 2.dp,
            )
            .padding(Sizes.INTERVAL_LARGE4)
    ) {
        Text(
            text = title,
            style = TextStyles.TITLE_MEDIUM2,
        )
        Spacer(modifier = Modifier.height(Sizes.INTERVAL3))
        Text(
            text = content,
            style = TextStyles.CONTENT_TEXT3_STYLE.copy(
                color = Colors.GREY_TEXT,
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Text(
                text = "Progress",
                style = TextStyles.CONTENT_SMALL1_STYLE.copy(
                    color = Colors.GREY_TEXT,
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${progress.first}/${progress.second}",
                style = TextStyles.CONTENT_SMALL1_STYLE.copy(
                    color = Colors.GREY_TEXT,
                ),
            )
        }
        Spacer(modifier = Modifier.height(Sizes.INTERVAL2))
        CustomProgress(
            width = 340.dp,
            height = 5.dp,
            progress = progress.first.toFloat()/progress.second.toFloat(),
            color = Colors.PRIMARY_BLUE,
        )

    }
}

@Composable
@Preview
fun AchievementItemPreview() {
    AchievementItem(
        title = "100",
        content = "Total Damage",
        progress = Pair(76, 100),
    )
}