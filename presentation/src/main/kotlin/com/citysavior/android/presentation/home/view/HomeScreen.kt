package com.citysavior.android.presentation.home.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
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


@Composable
fun HomeScreen(navController: NavController) {
    val items = List(3){}

   DefaultLayout(
       title = "Home",
       actions = {
           Icon(Icons.Filled.AccountCircle, contentDescription = "Account", tint = Color.Black)
       }
   ) {

       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 20.dp)
               .verticalScroll(rememberScrollState())
       ) {
           Text(
               "Hello\nUser",
               style = TextStyles.TITLE_BIG.copy(
                   lineHeight = 36.sp
               ),
           )
           Spacer(modifier = Modifier.height(20.dp))
           CustomChip(
               text = "Overview",
               textStyle = TextStyles.CONTENT_TEXT3_STYLE.copy(
                   color = Color.White,
               ),
               size = DpSize(
                   width = 120.dp,
                   height = 32.dp,
               ),
           )
          Spacer(modifier = Modifier.height(14.dp))
           DailyProgress(
               title = "Daily progress",
               subTitle = "Here you can see your reported damages",
               progress = Pair(76, 100),
           )
           Spacer(modifier = Modifier.height(20.dp))
           Text(
               "Categories",
               style = TextStyles.TITLE_LARGE2,
           )
           Spacer(modifier = Modifier.height(Sizes.INTERVAL2))
           for(i in 0 until (items.size/2)){
               Row{
                   CategoryItem(
                       modifier = Modifier.weight(1f),
                       subTitle = "Sub Title",
                       title = "Title",
                       progress = Pair(76, 100),
                   )
                   Spacer(modifier = Modifier.width(Sizes.INTERVAL0))
                   CategoryItem(
                       modifier = Modifier.weight(1f),
                       subTitle = "Sub Title",
                       title = "Title",
                       progress = Pair(76, 100),
                   )
               }
               Spacer(modifier = Modifier.height(Sizes.INTERVAL0))
           }
           if(items.size%2 == 1){
               Row {
                   CategoryItem(
                          modifier = Modifier.weight(1f),
                          subTitle = "Sub Title",
                          title = "Title",
                          progress = Pair(76, 100),
                     )
                   Spacer(modifier = Modifier.width(Sizes.INTERVAL0))
                   Spacer(modifier = Modifier.weight(1f))
               }
           }

       }

   }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}