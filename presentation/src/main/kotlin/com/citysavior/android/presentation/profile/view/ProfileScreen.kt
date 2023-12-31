package com.citysavior.android.presentation.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.citysavior.android.presentation.common.constant.Sizes
import com.citysavior.android.presentation.common.constant.TextStyles
import com.citysavior.android.presentation.common.layout.DefaultLayout
import com.citysavior.android.presentation.home.component.CategoryItem
import com.citysavior.android.presentation.home.component.CustomChip
import com.citysavior.android.presentation.home.component.DailyProgress
import com.citysavior.android.presentation.profile.component.AchievementItem
import com.citysavior.android.presentation.profile.component.ProfileBox
import com.citysavior.android.presentation.profile.component.ProfileStatItem


@Composable
fun ProfileScreen(navController: NavController) {
    DefaultLayout {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier =Modifier.height(Sizes.INTERVAL0))
            ProfileBox(
                title = "DamageTracker",
                content = "View damage at a glance",
            )
            Spacer(modifier = Modifier.height(Sizes.INTERVAL_LARGE4))
            Text(
                text = "View damage at a glance",
                style = TextStyles.TITLE_MEDIUM2,
            )
            Spacer(modifier = Modifier.height(Sizes.INTERVAL_MEDIUM2))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ProfileStatItem(
                    modifier = Modifier.weight(1f),
                    label = "100",
                    content = "Total reported\ndamage",
                )
                ProfileStatItem(
                    modifier = Modifier.weight(1f),
                    label = "100",
                    content = "Repairs\ncompleted",
                )
                ProfileStatItem(
                    modifier = Modifier.weight(1f),
                    label = "100",
                    content = "Rewards\ncollected",
                )
            }
            Spacer(modifier = Modifier.height(14.dp))

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Achievements",
                style = TextStyles.TITLE_MEDIUM2,
            )
            Spacer(modifier = Modifier.height(Sizes.INTERVAL2))

            List(2){
                AchievementItem(
                    modifier = Modifier.padding(
                        vertical = Sizes.INTERVAL4,
                        horizontal = 1.dp,
                    ),
                    title = "Master of Disaster",
                    content = "Report 100 damage",
                    progress = Pair(76, 100),
                )
            }
        }

    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = NavController(LocalContext.current))
}