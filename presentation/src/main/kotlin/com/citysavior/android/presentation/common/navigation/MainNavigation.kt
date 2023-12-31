package com.citysavior.android.presentation.common.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.citysavior.android.presentation.common.view.MainRootTab

const val MAIN_GRAPH_ROUTE_PATTERN = "/"
const val MAIN_ROUTE = "main"

fun NavGraphBuilder.mainGraph(
    navController: NavController,
){
    navigation(
        route = MAIN_GRAPH_ROUTE_PATTERN,
        startDestination = MAIN_ROUTE,
    ) {
        composable(route = MAIN_ROUTE) {
            MainRootTab(navController)
        }

    }
}