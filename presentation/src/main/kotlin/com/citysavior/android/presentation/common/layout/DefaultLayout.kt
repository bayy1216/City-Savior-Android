package com.citysavior.android.presentation.common.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysavior.android.presentation.common.constant.Colors
import com.citysavior.android.presentation.common.constant.TextStyles


/**
 * DefaultLayout is a composable function that takes a title and a content lambda as parameters.
 * You can easily create a screen with a topAppBar and a content.
 * @param title the title of the screen. If title is not null, it will be displayed in the topAppBar.
 * @param actions should be used when you want to add buttons to the topAppBar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultLayout(
    title: String? = null,
    actions: @Composable RowScope.() -> Unit = {},
    body: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            title?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(
                            Color.White
                        )
                        .padding(
                            horizontal = 20.dp,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = title,
                        style = TextStyles.CONTENT_TEXT2_STYLE,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    actions()
                }
            }
        },
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(Colors.BACKGROUND_COLOR)
        ) {
            body()
        }
    }

}


@Preview
@Composable
fun DefaultLayoutPreview() {
    DefaultLayout(
        title = "Title",
        actions ={
            Text(text = "Actions")
        }
    ) {
        Text(text = "Content")
    }
}