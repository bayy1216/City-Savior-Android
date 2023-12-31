package com.citysavior.android.presentation.common.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.citysavior.android.presentation.common.constant.Colors
import com.citysavior.android.presentation.common.constant.TextStyles
import com.citysavior.android.presentation.common.utils.noRippleClickable
import com.citysavior.android.presentation.home.view.HomeScreen
import com.citysavior.android.presentation.profile.view.ProfileScreen

enum class BottomNavRouter(
    val routePath: String,
    val korean: String,
    val icon: ImageVector,
) {
    HOME("home", "홈", Icons.Default.Home),
    MAP("map", "지도", Icons.Default.Home),
    PROFILE("profile", "내정보", Icons.Default.Home),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainRootTab(
    navController: NavController,
){
    val items = BottomNavRouter.values().toList()

    val mainNavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            val navBackStackEntry by mainNavHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute in items.map { it.routePath }) {
                NavigationBar(
                    modifier = Modifier.shadow(
                        elevation = 15.dp,
                        spotColor = Color(0xff000000),
                        ambientColor = Color(0xff000000),
                    ),
                    containerColor = Colors.WHITE,
                ) {
                    items.forEach { item ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .noRippleClickable {
                                    mainNavHostController.navigate(item.routePath) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                        ) {
                            Icon(imageVector = item.icon, contentDescription = null)
                            Text(text = item.korean, style = TextStyles.CONTENT_SMALL2_STYLE)
                        }
                    }
                }

            }
        }
    ) { innerPadding ->
        NavHost(
            navController = mainNavHostController,
            startDestination = BottomNavRouter.MAP.routePath,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomNavRouter.HOME.routePath) {
                HomeScreen(navController)
            }
            composable(route = BottomNavRouter.MAP.routePath) {
                Text("구글맵")
            }
            composable(route = BottomNavRouter.PROFILE.routePath) {
                ProfileScreen(navController)
            }
        }
    }
}