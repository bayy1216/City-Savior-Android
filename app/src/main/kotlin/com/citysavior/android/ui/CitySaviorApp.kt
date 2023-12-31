package com.citysavior.android.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.citysavior.android.R
import com.citysavior.android.core.utils.NetworkMonitor
import com.citysavior.android.navigation.CitySaviorNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitySaviorApp(
    networkMonitor: NetworkMonitor,
    appState: CitySaviorAppState = rememberCitySaviorAppState(
        networkMonitor = networkMonitor,
    ),
) {
    val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val notConnectedMessage = stringResource(R.string.not_connected)
    LaunchedEffect(isOffline) {
        if (isOffline) {
            Log.d("CitySaviorApp", "isOffline: $isOffline")
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }

    Scaffold(
        // ... other parameters for Scaffold
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it),
        ) {
            CitySaviorNavHost(
                appState = appState,
            )
        }
    }
}